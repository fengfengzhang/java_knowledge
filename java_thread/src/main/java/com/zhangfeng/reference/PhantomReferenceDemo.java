package com.zhangfeng.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @ClassName PhantomReferenceDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 21:15
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(o1, queue);
        System.out.println(o1);
        System.out.println(p.get());
        System.out.println(queue.poll());
        System.out.println("======");

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(p.get());
        System.out.println(queue.poll());
    }
}
