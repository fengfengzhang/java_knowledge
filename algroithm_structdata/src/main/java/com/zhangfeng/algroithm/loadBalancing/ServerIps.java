package com.zhangfeng.algroithm.loadBalancing;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ServerIps
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/3 12:49
 */
public class ServerIps {

    public  static List<String> List = Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10"
    );

    public static  final Map<String,Integer> WEIGHT_LIST = new LinkedHashMap<>();
    static {
        //权重之和50
        WEIGHT_LIST.put("192.168.0.1",1);
        WEIGHT_LIST.put("192.168.0.2",8);
        WEIGHT_LIST.put("192.168.0.3",3);
        WEIGHT_LIST.put("192.168.0.4",6);
        WEIGHT_LIST.put("192.168.0.5",5);
        WEIGHT_LIST.put("192.168.0.6",5);
        WEIGHT_LIST.put("192.168.0.7",4);
        WEIGHT_LIST.put("192.168.0.8",7);
        WEIGHT_LIST.put("192.168.0.9",2);
        WEIGHT_LIST.put("192.168.0.10",9);
    }


    public static void main(String[] args) {

    }
}
