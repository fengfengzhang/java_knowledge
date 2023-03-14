package com.zhangfeng.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockSupportDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 12:59
 */
public class LockSupportDemo {

    static final Object object = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
//        synchronizedWaitAndNotify();
//        lockAwaitAndSignal();
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "进入当前线程");
            /**
             * 如果先unpark，后park,后面也不会阻塞，后面都得park不起作用
             * 调用unpark凭证变为1，多次调用不会累加，最多为1，被设置为1的线程，将被唤醒不会被阻塞
             */
            LockSupport.park();//被阻塞等待通知，它的通知需要许可证
            System.out.println(Thread.currentThread().getName() + "当前线程被唤醒");
        }, "a");

        a.start();

        TimeUnit.SECONDS.sleep(3);

        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"进入当前线程");
            //唤醒哪个线程
            LockSupport.unpark(a);
            }, "b");
        b.start();

    }

    private static void lockAwaitAndSignal() {
        new Thread(()->{
            lock.lock();
                System.out.println(Thread.currentThread().getName() + "当前线程在执行");
            try {
                //await()和signal()必须和加索解锁在一块，先await()在signal()
                condition.await();
                System.out.println(Thread.currentThread().getName() + "当前线程被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"A").start();


        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "唤醒别人");
            condition.signal();
            lock.unlock();
        },"B").start();
    }

    private static void synchronizedWaitAndNotify() {
        new Thread(()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "当前线程");
                try {
                    //wait不能脱离synchronized而执行
                    //一定要先wait在notify,如果反了，就不会被唤醒
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

 //               System.out.println("被唤醒");
            }
        },"A").start();

        new Thread(()->{
            synchronized (object){
                object.notify();
 //               System.out.println("唤醒完了");
                System.out.println(Thread.currentThread().getName()+"唤醒");

            }
        },"B").start();
    }
}
