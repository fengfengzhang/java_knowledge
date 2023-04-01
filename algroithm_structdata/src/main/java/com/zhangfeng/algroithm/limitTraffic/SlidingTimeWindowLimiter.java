package com.zhangfeng.algroithm.limitTraffic;

import java.util.LinkedList;

/**
 * @ClassName SlidingTimeWindowLimiter
 * @Description 滑动窗口限流
 * @Author zhangfeng
 * @Date 2023/4/1 20:36
 */
public class SlidingTimeWindowLimiter implements  TrafficLimiter{
    //服务器最近1秒内的访问次数。可以放在redis中，实现分布式系统的访问计数
    private int reqCount;
    //使用LinkedList来记录华东窗口的10个格子
    private LinkedList<Integer> slots = new LinkedList<>(); //替换成redis中list,实现分布式
    private int limitNum = 100;//每秒限流的最大请求数
    private long windowLength = 100L;//滑动时间窗口里每个时间的长度，单位毫秒
    private int windowNum = 10;//滑动时间窗口里的格子数

    @Override
    public synchronized Boolean limit() {
        if(reqCount+1>limitNum){
            return true;
        }

        slots.set(slots.size() -1,slots.peekLast() + 1);
        reqCount ++;
        return false;
    }


    public SlidingTimeWindowLimiter(){
        slots.addLast(0);
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(windowLength);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this){
                    slots.addLast(0);
                    if(slots.size() > windowNum){
                        reqCount = reqCount - slots.peekFirst();
                        slots.removeFirst();
                        System.out.println("滑动格子"+reqCount);
                    }
                }
            }
        }).start();
    }
}
