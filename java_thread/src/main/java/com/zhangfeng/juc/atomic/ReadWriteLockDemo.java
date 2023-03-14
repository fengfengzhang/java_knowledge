package com.zhangfeng.juc.atomic;

/**
 * @ClassName ReadWriteLockDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 22:09
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读共存
 * 读写不能共存
 * 写写不能共存
 */

class MyCache{//资源类

    private volatile Map<String,Object> map = new HashMap<>();
//    private Lock lock = new ReentrantLock();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();

    private Lock writeLock = lock.writeLock();

    public  void put(String key, Object value) throws InterruptedException {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            TimeUnit.SECONDS.sleep(5);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        }finally {
            writeLock.unlock();
        }
    }
    public Object get(String key) throws InterruptedException {
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "读"+key);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "读完成");
            return map.get(key);

        }finally {
            readLock.unlock();
        }
    }


}




public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();


        for(int i = 0; i < 5 ;i ++){
            final int temp = i;
            new Thread(()->{
                try {
                    myCache.put(String.valueOf(temp),temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },i+"").start();
        }

        for(int i = 0; i < 5 ;i ++){
            final int temp = i;
            new Thread(()->{
                try {
                    System.out.println(myCache.get(String.valueOf(temp)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },i+"").start();
        }


    }
}
