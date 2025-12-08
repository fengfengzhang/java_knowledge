package com.zhangfeng.algroithm.limitTraffic;

/**
 * @ClassName TokenBucketLimiter
 * @Description 令牌桶限流算法
 * @Author zhangfeng
 * @Date 2023/4/1 21:22
 */
public class TokenBucketLimiter implements TrafficLimiter{
    private long timeStamp = System.currentTimeMillis();
    private long capacity = 100;//桶的容量
    private long rate = 10;//令牌放入速度
    private long tokens = 20;//当前令牌数里

    @Override
    public synchronized Boolean limit() {
        long now = System.currentTimeMillis();
        //先添加令牌
        tokens = Math.min(capacity, tokens + (now - timeStamp) /1000 * rate);
        timeStamp = now;
         if(tokens < 1){
             //若不到1个令牌，则拒绝
             return true;
         }else{
             //还有令牌，则领取令牌
             tokens --;
             return false;
         }

    }
}
