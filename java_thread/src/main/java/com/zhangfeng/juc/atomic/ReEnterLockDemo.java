package com.zhangfeng.juc.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReEnterLOckDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 12:27
 */
public class ReEnterLockDemo {

    static Object obj = new Object();

    public static void m1() {
        new Thread(()->{
            //同一把锁，可重入，同一把锁
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "外层");
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName() + "内层");
                }
            }
            },"t1").start();
    }

    public static synchronized void m2(){
        System.out.println("m2=====");
        m3();
    }

    //synchronized 底层monitor
    //所对象拥有一个锁计数器，和指向持有该锁的指针。

    /**
     * 当执行monitorenter时候，如果目标计数器为0那么没有线程持有该锁
     * jvm会把指针指向当前线程，并且计数器加1
     * 该目标锁对象计数器不为0，如果持有锁对象的线程是当前线程，计数器在加一，释放一次减一
     *
     */


    public static synchronized void m3(){
        System.out.println("m3=====");
    }


    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        m1();
//          m2();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("===外层");
                lock.lock();
                try {
                    System.out.println("===内层");
                }finally {
                    lock.unlock();
                }
            }finally {
                //不释放锁其他线程，无法获取
                lock.unlock();
            }
        },"t1").start();


        new Thread(()->{
            lock.lock();
            try {
                System.out.println("t2调用");
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
