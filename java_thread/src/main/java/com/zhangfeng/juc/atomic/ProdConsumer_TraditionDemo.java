package com.zhangfeng.juc.atomic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ProdConsumer_TraditionDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 12:42
 */

class ShareData{

    private  int number = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    //多线程操作，防止虚假唤醒，用while
    public void increment() throws  Exception{
        lock.lock();
        try {
            //1.判断
            while (number != 0) {
                //等待不能生产
                condition.await();

            }
            number++;
            System.out.println(Thread.currentThread().getName() + " " + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void deIncrement()throws  Exception{
        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                //等待不能生产
                condition.await();

            }
            number--;
            System.out.println(Thread.currentThread().getName() + " " + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 题目一个初始变量为0，两个线程对齐交替操作，一个加一个减来5次
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for(int i= 0; i < 5 ;i ++){
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for(int i= 0; i < 5 ;i ++){
                try {
                    shareData.deIncrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

    }

}
