package com.zhangfeng.reference;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftReferenceDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 20:24
 */
public class SoftReferenceDemo {
    /**
     * 内存足够不回收，内存不够就会被回收
     * 缓存中使用
     */

    public static  void softRef_Memory() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1 = null;
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch (Exception e){

        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        softRef_Memory();
    }
}
