package com.zhangfeng.juc.atomic.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName interruptDemo2
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 15:36
 */
public class interruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                for(int i = 0; i < 300; i ++){
                    System.out.println(i);
                }
            } catch (InterruptedException e) {

            }

        },"t1");
        t1.start();

        System.out.println("t1线程的默认中断标识" + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(1);
        t1.interrupt();
        System.out.println("t1线程的默认中断标识" + t1.isInterrupted());

    }
}
