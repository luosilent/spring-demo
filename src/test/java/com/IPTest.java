package com;

import cn.hutool.core.net.NetUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luo
 * @date 2023/1/30 16:22
 */
public class IPTest {
    public static void main(String[] args) throws IOException {

        long num = NetUtil.ipv4ToLong("222.126.128.0");  //
        long num2 = NetUtil.ipv4ToLong("222.127.0.0");  //

        System.out.println(num);
        System.out.println(num2);
        System.out.println(num2 - num);
        Map<String, List<String>> ipHash = new HashMap<>();
        List<String> list = FileUtils.readLines(new File("D:/chinaip.txt"), StandardCharsets.UTF_8.name());
        for (String s : list) {
            System.out.println("解析网段 " + s);
            String[] ipSplit = s.split("\\.");
            // 取第一段的话，后面list的长度可能过大， 可以优化为取前两段， 这样后面list的长度都很小
//            String start = ipSplit[0] + "." + ipSplit[1];
            String start = ipSplit[0];
            List<String> childIps = ipHash.getOrDefault(start, new ArrayList<>());
            String str = getIpStartAndEnd(s);
            System.out.println("网段ip " + s + "起始范围 " + str);
            childIps.add(str);
            ipHash.put(start, childIps);
        }

        for (Map.Entry<String, List<String>> entry : ipHash.entrySet()) {
            System.out.println(entry.getKey() + " 网段数量 " + entry.getValue().size());
        }
        System.out.println(ipHash.size());
    }

    public static String getIpStartAndEnd(String s) {
        String[] array = s.split("/");
        long start = NetUtil.ipv4ToLong(array[0]);
        Double num = Math.pow(2, 32 - Integer.parseInt(array[1]));
        long end = start + num.longValue();
        System.out.println("网段 : " + s + " 共有ip数量 " + num);
        return start + ":" + end;

    }
}
