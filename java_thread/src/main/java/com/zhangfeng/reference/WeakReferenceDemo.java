package com.zhangfeng.reference;

import java.lang.ref.WeakReference;

/**
 * @ClassName WeakReferenceDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 20:44
 */
public class WeakReferenceDemo {

    /**
     * 弱引用只要发生gc就清除
     */
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        System.out.println(o);
        System.out.println(weakReference.get());

        System.out.println("=====");
        o = null;
        System.gc();
        System.out.println(o);
        System.out.println(weakReference.get());
    }
}
