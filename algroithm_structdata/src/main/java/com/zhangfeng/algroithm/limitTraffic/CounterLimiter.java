package com.zhangfeng.algroithm.limitTraffic;

/**
 * @ClassName CounterLimiter
 * @Description 请求计数限流
 * @Author zhangfeng
 * @Date 2023/4/1 20:18
 */
public class CounterLimiter implements  TrafficLimiter
{
    /**
     * 存在问题，每秒限流100，1.5秒到2秒时候可能没限制住
     */

    private long timeStamp = System.currentTimeMillis();
    private int reqCount;//请求数
    private int limitNum = 100;//每秒限流最大请求数
    private long interval = 1000L;//时间窗口时长，单位毫秒

    //可以利用redis实现。System.currentTimeMillis()/1000作为key,原子加

    @Override
    public synchronized Boolean limit() {
       long now = System.currentTimeMillis();
       if(now < timeStamp + interval){//当前时间窗口
           //判断当前时间窗口请求数加1是否超过每秒限流最大请求数
           if(reqCount + 1 > limitNum){
               return true;
           }
           reqCount ++;
       }else{
           //开始新的时间窗口
           timeStamp = now;
           //重置计数器
           reqCount = 1;
       }
        return false;
    }
}
