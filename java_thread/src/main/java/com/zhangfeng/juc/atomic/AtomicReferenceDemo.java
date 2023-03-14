package com.zhangfeng.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName AtomicRefence
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 22:36
 */
public class AtomicReferenceDemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        //带时间戳的原子引用，解决ABA问题
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println(atomicReference.compareAndSet(100, 2019) + "======" + atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("版本号"+stamp);
            try {
                Thread.sleep(1000);

                atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
                atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("版本号"+stamp);
            try {
                Thread.sleep(3000);
                System.out.println(atomicStampedReference.compareAndSet(100,2019,stamp,stamp + 1) + "=====" + atomicStampedReference.getReference() + "===="+atomicStampedReference.getStamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t4").start();

    }
}
