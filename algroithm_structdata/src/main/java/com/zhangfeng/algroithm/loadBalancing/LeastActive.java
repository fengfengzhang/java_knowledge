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
    public static String getServer(){
        // 1. 找出当前活跃数最小的服务器
        Optional<Integer> minValue = ACTIVITY_LIST.values().stream()
                .min(Comparator.naturalOrder());

        if(minValue.isPresent()){
            int minActivity = minValue.get();

            // 2. ✅ 找出所有活跃数等于最小值的服务器
            List<String> minActivityIps = new ArrayList<>();
            ACTIVITY_LIST.forEach((ip, activity) -> {
                if (activity == minActivity) {
                    minActivityIps.add(ip);
                }
            });

            // 3. 判断最小活跃数服务器数量
            if(minActivityIps.size() == 1){
                // 只有一个最小活跃数服务器，直接返回
                return minActivityIps.get(0);
            }else{
                // 4. 多个最小活跃数服务器，根据权重选择
                LinkedHashMap<String, Integer> weightList = new LinkedHashMap<>();
                ServerIps.WEIGHT_LIST.forEach((ip, weight) -> {
                    if(minActivityIps.contains(ip)){
                        weightList.put(ip, weight);
                    }
                });

                // 5. 计算总权重，判断权重是否相同
                int totalWeight = 0;
                boolean sameWeight = true;
                List<Integer> weights = new ArrayList<>(weightList.values());
                for(int i = 0; i < weights.size(); i++){
                    Integer weight = weights.get(i);
                    totalWeight += weight;
                    if(sameWeight && i > 0 && !weight.equals(weights.get(i-1))){
                        sameWeight = false;
                    }
                }

                // 6. 根据权重选择
                Random random = new Random();
                if(!sameWeight){
                    // ✅ 使用加权随机选择（累计权重）
                    int randomPos = random.nextInt(totalWeight);
                    int cumulativeWeight = 0;
                    for(String ip : weightList.keySet()){
                        cumulativeWeight += weightList.get(ip);
                        if(cumulativeWeight > randomPos){
                            return ip;
                        }
                    }
                }
                // 权重相同，随机选择一个
                return minActivityIps.get(random.nextInt(minActivityIps.size()));
            }
        }else{
            // 没有找到最小活跃数，随机选择一个
            List<String> allIps = new ArrayList<>(ServerIps.WEIGHT_LIST.keySet());
            return allIps.get(new Random().nextInt(allIps.size()));
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10 ; i++){
            System.out.println(getServer());
        }
    }
}

