package com.zhangfeng.juc.atomic;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AQSDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 19:44
 */
public class AQSDemo {

    //抽象的队列同步器

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("完事");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        },"a");
        A.start();


        Thread.currentThread().interrupt();
        Thread.sleep(5000);



        Lock lock = new ReentrantLock();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("A==== come in");
                TimeUnit.MINUTES.sleep(20);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"a").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("b==== come in");
            }finally {

                lock.unlock();
            }

        },"b").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("c==== come in");
            }finally {

                lock.unlock();
            }

        },"c").start();

    }


}
