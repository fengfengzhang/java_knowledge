package com.zhangfeng.juc.atomic.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName InterruptDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 15:18
 */
public class InterruptDemo {

   static volatile  boolean isStop = false;

   static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
//        m1();
//        m2();
        Thread t1 = new Thread(
                ()->{
                    while (true){
                        if(Thread.currentThread().isInterrupted()){
                            System.out.println(Thread.currentThread().getName() +"程序停止");
                            break;
                        }
                        System.out.println("interrupted");
                    }
                }
                ,"t1");

        t1.start();

        TimeUnit.SECONDS.sleep(3);
        t1.interrupt();
        TimeUnit.SECONDS.sleep(1);



    }

    private static void m2() throws InterruptedException {
        new Thread(
                ()->{
                    while (true){
                        if(atomicBoolean.get()){
                            System.out.println(Thread.currentThread().getName() +"程序停止");
                            break;
                        }
                        System.out.println("atomicBoolean");
                    }
                }
                ,"t1").start();


        TimeUnit.SECONDS.sleep(3);
        atomicBoolean.set(true);
        TimeUnit.SECONDS.sleep(1);
    }

    private static void m1() throws InterruptedException {
        new Thread(
                ()->{
                    while (true){
                        if(isStop){
                            System.out.println(Thread.currentThread().getName() +"程序停止");
                            break;
                        }
                        System.out.println("volatile");
                    }
                }
        ,"t1").start();


        TimeUnit.SECONDS.sleep(3);
        isStop = true;
        TimeUnit.SECONDS.sleep(1);
    }
}
