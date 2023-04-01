package com.zhangfeng.algroithm.limitTraffic;

public interface TrafficLimiter {

    /**
     * 返回true代表限流,false代表通过
     * @return
     */
    Boolean limit();
}
