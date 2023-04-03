package com.zhangfeng.algroithm.loadBalancing;

import java.util.ArrayList;

/**
 * @ClassName Random
 * @Description 负载均衡随机算法
 * @Author zhangfeng
 * @Date 2023/4/3 12:51
 */
public class Random {

    public static String getServer(){
        int totalWeight = 0;
        for(Integer weight : ServerIps.WEIGHT_LIST.values()){
             totalWeight += weight;
         }

        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(totalWeight);
        String resIp = "";
        for(String ip : ServerIps.WEIGHT_LIST.keySet()){
           if (ServerIps.WEIGHT_LIST.get(ip) > pos){
               resIp = ip;
               break;
           }else{
               pos -= ServerIps.WEIGHT_LIST.get(ip);
           }
        }

        return resIp;

    }

    private static String fun1() {
        ArrayList<String> ips = new ArrayList<>();

        for(String ip : ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);

            //权重进行赋值。内存效率低
            for (int i = 0; i < weight; i++) {
                ips.add(ip);
            }
        }
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(ips.size());
        return ips.get(randomPos);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(getServer());
        }
    }
}
