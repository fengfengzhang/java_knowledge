package com.zhangfeng.reference;

/**
 * @ClassName StrongReferenceDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 20:22
 */
public class StrongReferenceDemo {

    /**
     * 强引用不会被垃圾回收
     */
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        byte[] bytes = new byte[30 * 1024 * 1024];
        System.out.println(obj2);
        System.out.println(obj1);
    }
}
