package com.zhangfeng.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MyThreadPoolDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 17:28
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
          ExecutorService threadPool = Executors.newCachedThreadPool();
        try{
            for(int i = 0; i < 10 ; i++){
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
/**
 * 核心线程数，最大线程数，多余线程存活的时间
 * 多余线程存活的时间单位，阻塞队列，线程工厂，拒绝策略
 *
 */
