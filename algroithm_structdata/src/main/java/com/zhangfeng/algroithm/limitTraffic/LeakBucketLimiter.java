package com.zhangfeng.algroithm.limitTraffic;

/**
 * @ClassName LeakBucketLimiter
 * @Description 漏桶算法
 * @Author zhangfeng
 * @Date 2023/4/1 21:07
 */
public class LeakBucketLimiter implements  TrafficLimiter{

    private long timeStamp = System.currentTimeMillis();
    private long capacity = 100;//桶容量
    private long rate = 10;//水露出的速度(每秒系统处理的请求数)
    private long water = 20;//当前水量(当前累积请求数)

    @Override
    public synchronized Boolean limit() {
        long now = System.currentTimeMillis();
        //先执行漏水。计算剩余水量（计算剩余请求次数）
        water = Math.max(0,water-((now - timeStamp)/1000)*rate);
        timeStamp = now;
        if(water + 1 <= capacity){
            //水未满，加水
            water ++;
            System.out.println("加水"+water);
            return false;
        }else{
            //水满拒绝加水
            return true;
        }
    }
}
