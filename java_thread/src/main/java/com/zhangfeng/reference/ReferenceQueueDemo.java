package com.zhangfeng.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ReferenceQueueDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 21:10
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference(o,objectReferenceQueue);
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(objectReferenceQueue.poll());
        o = null;

        TimeUnit.SECONDS.sleep(1);
        System.gc();
        System.out.println(o);
        System.out.println(weakReference.get());

        /**
         * 软，弱，虚，都会有这个情况
         * 发生gc回收，会把弱引用放在引用队列里，
         * 未发生gc则不会放进去
         */
        System.out.println(objectReferenceQueue.poll());


    }
}
