package com.zhangfeng.juc.atomic;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 23:21
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量主要用于两个目的。一个是用于多个共享资源互斥使用
 * 另一个用于并发线程数控制
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0; i <= 6; i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "停车3秒后离开");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }
            ,String.valueOf(i)).start();
        }
    }
}
