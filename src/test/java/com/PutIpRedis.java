package com;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.net.NetUtil;
import com.alibaba.fastjson.JSON;
import com.web.util.RedisUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author luo
 * @date 2023/1/30 15:20
 */
@SpringBootTest
public class PutIpRedis {
    @Resource
    private RedisUtil jc;
    private static final String IP_HASH_NAME = "china_ip_hash";
    private static final String IP_FILE_NAME = "D:/chinaip.txt";

    public static void main(String[] args) {

    }

    //处理所有的ip范围到redis
    @Test
    void setIpRedis() throws IOException {
        //从文件中得到所有的国内ip
        List<String> listAll = FileUtils.readLines(new File(IP_FILE_NAME), StandardCharsets.UTF_8.name());
        //遍历，得到所有的第一段
        HashSet<String> arrFirst = new HashSet<>();
        for (String str : listAll) {
            String one = StringUtils.trim(str);
            if (Objects.equals(one, "")) {
                continue;
            }
            String[] firstArr = one.split("\\.");
            if (StringUtils.isNotBlank(firstArr[0])) {
                arrFirst.add(firstArr[0]);
            }
        }

        //得到线上hash的所有key
        Set<Object> arrHKeys = jc.hkeys(IP_HASH_NAME);

        //如果一个线上已存在的key不再存在于新ip的第一段的数组中
        //需要从线上hash中删除
        if (!CollectionUtil.isEmpty(arrHKeys) && arrHKeys.size() > 0) {
            for (Object keyOne : arrHKeys) {
                if (!arrFirst.contains(keyOne.toString())) {
                    jc.hdel(IP_HASH_NAME, keyOne);
                }
            }
        }
        //得到每个第一段下面对应的所有ip地址段,保存到redis
        for (String first : arrFirst) {
            addAListByFirst(first, listAll);
        }

    }


    //把所有的第一段为指定数字的ip,添加到redis
    private void addAListByFirst(String first, List<String> arr) {

        List<String> arrLine = new ArrayList<>();
        for (String one : arr) {
            one = StringUtils.trim(one);
            String[] firstArr = one.split("\\.");
            if (StringUtils.isBlank(firstArr[0])) {
                continue;
            }

            if (Objects.equals(firstArr[0], first)) {
                String line = getLineByRangeOne(one);
                arrLine.add(line);
            }
        }

        if (!CollectionUtil.isEmpty(arrLine)) {
            //set一个数组到hash
            jc.hset(IP_HASH_NAME, first, JSON.toJSONString(arrLine));
        }
    }


    //得到一个ip地址段的起始范围
    private String getLineByRangeOne(String networkRange) {
        String[] strArr = networkRange.split("/");
        long networkStart = NetUtil.ipv4ToLong(strArr[0]);
        Double networkLen = Math.pow(2, 32 - Long.parseLong(strArr[1]));
        long networkEnd = networkStart + networkLen.longValue() - 1;
        return networkStart + "--" + networkEnd;
    }


}
