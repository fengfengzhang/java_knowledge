package com.zhangfeng.juc.atomic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SynchronousQueueDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 12:30
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println("put 1");
                blockingQueue.put("1");
                System.out.println("put 2");
                blockingQueue.put("2");
                System.out.println("put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("take 1");
                System.out.println(blockingQueue.take());
                System.out.println("take 2");
                System.out.println(blockingQueue.take());
                System.out.println("take 3");
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();


    }
}
