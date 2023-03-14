package com.zhangfeng.juc.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatch
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 22:36
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 2 ; i++ ){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "上自习");
                countDownLatch.countDown();
                },String.valueOf(CountryEnum.get(i))).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "锁门");
    }
}
