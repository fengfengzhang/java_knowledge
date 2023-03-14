package com.zhangfeng.juc.atomic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CydicBarrierDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 23:10
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });

        for(int i = 1 ; i <=7 ;i++ ){
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "收集到龙珠");

                    TimeUnit.SECONDS.sleep(3);
                    cyclicBarrier.await();
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
