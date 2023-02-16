package com;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.net.NetUtil;
import com.alibaba.fastjson.JSON;
import com.web.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luo
 * @date 2023/1/30 15:20
 */
@SpringBootTest
public class IpInChinaTest {
    @Resource
    private RedisUtil jc;
    private static final String IP_HASH_NAME = "china_ip_hash";
    public static void main(String[] args) {

    }
    @Test
     void test() {
        System.out.println("判断一个ip是否属于china：" + isIpInChina("222.126.128.0")); //输出true
        System.out.println("判断一个ip是否属于china：" + isIpInChina("222.127.0.0")); //输出false
    }

    //判断一个ip是否属于china
    private Boolean isIpInChina(String ip) {
        ip = StringUtils.trim(ip);
        String[] ipSplit = ip.split("\\.");

        if (StringUtils.isBlank(ipSplit[0])) {
            //ip有误，按国外算
            return false;
        }
        String first = ipSplit[0];
        List<String> arrRange = hashGet(first);
        if (CollectionUtil.isEmpty(arrRange)) {
            return false;
        }

        return isIpInArrRange(ip, arrRange);
    }

    //判断一个ip是否属于ip的range数组
    private Boolean isIpInArrRange(String ip, List<String> arrRange) {
        long ipLong = NetUtil.ipv4ToLong(ip);
        for (String one : arrRange) {
            one = StringUtils.trim(one);

            String[] arrOne = one.split("--");

            if (StringUtils.isBlank(arrOne[0]) || StringUtils.isBlank(arrOne[1])) {
                continue;
            }

            long begin = Long.parseLong(arrOne[0]);
            long end = Long.parseLong(arrOne[1]);

            if (ipLong >= begin && ipLong <= end) {
                return true;
            }
        }
        return false;
    }

    //得到一个hash中对应key的value
    private List<String> hashGet(String keyName) {
        Object str = jc.hget(IP_HASH_NAME, keyName);
        if (str == null)
            return new ArrayList<>();
        return JSON.parseArray(str.toString(), String.class);
    }


}
