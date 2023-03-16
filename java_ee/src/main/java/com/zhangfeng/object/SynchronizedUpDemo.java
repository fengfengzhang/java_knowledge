package com.zhangfeng.object;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SynchronizedUpDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/16 21:28
 */
public class SynchronizedUpDemo {

    public static void main(String[] args) throws InterruptedException {

//        noBlock();

//        deflectionLock();

//        lightweightLocking();

//          mutexLock();

        /**
            计算hashCode，就无法变成偏向锁,
            偏向锁，如果计算hashcode，就变成重量级锁
            轻量级锁，hashCode，会存在线程，栈帧的锁记录，保存一份，释放锁后写会对象的markWord
            重量级锁中的monitor 会存错对象的markWord
         */
        hashCodeByObj();


    }

    //hashCode对锁的影响
    private static void hashCodeByObj() {
       /* Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
       */

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            o.hashCode();
            System.out.println(ClassLayout.parseInstance(o).toPrintable());

        }

    }

    //重量级锁 ，当前指针指向线程 monitor对象
    private static void mutexLock() {
        Object o = new Object();

        new Thread(()->{
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
        new Thread(()->{
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }

    //轻量级锁 当前指针指向线程 Lock Record（帧记录）
    private static void lightweightLocking() {
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }

    //偏向锁 当前指针指向线程id
    private static void deflectionLock() throws InterruptedException {
    /*
    偏向锁
    启用参数:
    -XX:+UseBiasedLocking
    关闭延迟:
    -XX:BiasedLockingStartupDelay=0
    禁用参数:
    -XX:-UseBiasedLocking

     */
        TimeUnit.SECONDS.sleep(5);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(()->{
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }

    //无锁
    private static void noBlock() {
        Object o = new Object();
//        o.hashCode();//native方法没调用不会有

        System.out.println("10进制:"+ o.hashCode());
        System.out.println("16进制:"+ Integer.toHexString(o.hashCode()));
        System.out.println("二进制:"+ Integer.toBinaryString(o.hashCode()));
        //整体从后往前看，每8位从前往后看
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
