package com.zhangfeng.algroithm.loadBalancing;

import java.util.*;
import java.util.Random;

/**
 * @ClassName LeastActive
 * @Description 最小活跃次数算法
 * @Author zhangfeng
 * @Date 2023/4/3 15:40
 */
public class LeastActive {

    //服务器当前的最小活跃数，（模拟）
    public static final Map<String,Integer> ACTIVITY_LIST = new LinkedHashMap<>();

    static {
        ACTIVITY_LIST.put("192.168.0.1",2);
        ACTIVITY_LIST.put("192.168.0.2",0);
        ACTIVITY_LIST.put("192.168.0.3",1);
        ACTIVITY_LIST.put("192.168.0.4",3);
        ACTIVITY_LIST.put("192.168.0.5",0);
        ACTIVITY_LIST.put("192.168.0.6",1);
        ACTIVITY_LIST.put("192.168.0.7",4);
        ACTIVITY_LIST.put("192.168.0.8",2);
        ACTIVITY_LIST.put("192.168.0.9",7);
        ACTIVITY_LIST.put("192.168.0.10",3);
    }

    /**
     * 优先选择活跃次数小的，然后比较权重，权重相同返回随机一个
     * @return
     */
    public static  String getServer(){
        //找出当前活跃数最小的服务器
        Optional<Integer> minValue = ACTIVITY_LIST.values().stream().min(Comparator.naturalOrder());
        if(minValue.isPresent()){
            List<String> minActivityIps = new ArrayList<>();
            ACTIVITY_LIST.forEach((ip,activity)-> minActivityIps.add(ip));
            //最小活跃数ip大于1则根据权重来选，选权重最大的优先
            if(minActivityIps.size() > 1){
                LinkedHashMap<String, Integer> weightList = new LinkedHashMap<>();
                ServerIps.WEIGHT_LIST.forEach((ip,weight)->{
                     if(minActivityIps.contains(ip)){
                         weightList.put(ip,ServerIps.WEIGHT_LIST.get(ip));
                     }
                });

                int totalWeight = 0;
                boolean sameWeight = true; //所有权重相等随机一个ip
                Object[] weights = weightList.values().toArray();
                for(int i = 0; i<weights.length ; i++){
                    Integer weight =  (Integer) weights[i];
                    totalWeight += weight;
                    if(sameWeight && i > 0 && !weight.equals( weights[i-1])){
                        sameWeight = false;
                    }
                }
                Random random = new Random();
                int randomPos = random.nextInt(totalWeight);

                if(!sameWeight){
                    for(String ip : weightList.keySet()){
                        Integer value = weightList.get(ip);
                        if(randomPos < value){
                            return ip;
                        }
                        randomPos -= value;
                    }
                }

                return (String)weightList.keySet().toArray()[new Random().nextInt(weightList.size())];


            }else {
                return minActivityIps.get(0);
            }

        }else{
            return (String)ServerIps.WEIGHT_LIST.keySet().toArray()[new Random().nextInt(ServerIps.WEIGHT_LIST.size())];

        }

    }

    public static void main(String[] args) {
        for(int i = 0; i < 10 ; i++){
            System.out.println(getServer());
        }
    }
}

