package com.zhangfeng.algroithm.loadBalancing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName RoundRobin
 * @Description 负载均衡轮询
 * @Author zhangfeng
 * @Date 2023/4/3 13:24
 */
public class RoundRobin {



    private static Integer pos = 0;

    private static final Object obj = new Object();

    public static String getServer(){
       return roundRobinByCurrentWeight();

    }

    /*
      平滑加权轮询算法，避免多次请求一直访问一台机器
       服务器
       1.ip
       2.weight         静态权重
       3.currentWeight  动态权重

       A:5
       B:1
       C:1
       总权重7
       currentWeight 0,0,0
       currentWeight = currentWeight + weight     max(currentWeight)   return   max(currentWeight) = currentWeight - totalWeight
     1.    5,1,1                                    5                     A          -2,1,1
     2.    3,2,2                                    3                     A          -4,2,2
     3.    1,3,4                                    3                     B          1,-4,3
     4.    6,-3,4                                   6                     A          1,3,4

     */
    private static Map<String,Weight> weights = new ConcurrentHashMap<>();


    private static String roundRobinByCurrentWeight(){
        String ip = null;
        int total = 0;
        for(Integer weight : ServerIps.WEIGHT_LIST.values()){
            total += weight;
        }

        if(weights.isEmpty()){
            ServerIps.WEIGHT_LIST.forEach((k,v)-> weights.put(k,new Weight(k,v,0)));
        }

        for (Weight weight: weights.values()){
            weight.setCurrentWeight(weight.getWeight() + weight.getCurrentWeight());
        }

        Weight maxCountWeight = null;

        for (Weight weight: weights.values()){
            if(maxCountWeight == null || weight.getCurrentWeight() > maxCountWeight.getCurrentWeight()){
                maxCountWeight = weight;
            }

        }

        maxCountWeight.setCurrentWeight(maxCountWeight.getCurrentWeight() - total);
        ip = maxCountWeight.getIp();

        return ip;

    }



    //按照权重依次轮询
    private static  String roundRobinByWeight(){
        String resIp = "";
        int total = 0;
        for(Integer weight : ServerIps.WEIGHT_LIST.values()){
            total += weight;
        }

        Integer requestId = RequestId.getAndIncrement();
        int posId = requestId % total;

        synchronized (obj){

            if(posId >= total){
                posId = 0;
            }
            int temp = posId;
            for(String ip : ServerIps.WEIGHT_LIST.keySet()){
                if(temp < ServerIps.WEIGHT_LIST.get(ip)){
                    resIp = ip;
                    break;
                }else{
                    temp -= ServerIps.WEIGHT_LIST.get(ip);
                }
            }

        }

        return resIp;


    }

    //无权重轮询
    private static String roundRobin1() {
        String ip = null;
        synchronized (obj){
            if(pos >= ServerIps.List.size()){
                pos = 0;
            }
            ip = ServerIps.List.get(pos);
            pos ++;
        }
        return ip;
    }

    public static void main(String[] args) {

        for(int i = 0; i < 50 ;i++){
            System.out.println(getServer());
        }

    }
}


//请求id
class RequestId{
    public static   Integer num = 0;
    public static Integer getAndIncrement(){
        return num++;
    }

}

/**
 * 权重
 */
class Weight{
   private String ip;
   private Integer weight;
   private Integer currentWeight;

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
