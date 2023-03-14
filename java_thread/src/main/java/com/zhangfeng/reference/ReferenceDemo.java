package com.zhangfeng.reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ReferenceDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 22:50
 */
public class ReferenceDemo {

   public static class MyObject{
       //对象被垃圾回收器收集清除之前调用
       @Override
       protected void finalize() throws Throwable {
           System.out.println("finalize");
           super.finalize();
       }
   }

    public static void main(String[] args) throws InterruptedException {
//        strongReference();

//        softReference();

   }

    private static void softReference() throws InterruptedException {
        SoftReference<Object> softReference = new SoftReference<>(new MyObject());
        System.gc();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("gc after" + softReference.get());
    }

    private static void strongReference() {
        MyObject myObject = new MyObject();
        System.out.println("gc before" + myObject);
        new SoftReference<Object>(myObject);

        myObject = null;
        System.gc();//认工开启gc
        System.out.println("gc after" + myObject);
    }
}
