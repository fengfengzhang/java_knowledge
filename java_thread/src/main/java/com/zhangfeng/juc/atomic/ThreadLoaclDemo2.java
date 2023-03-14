package com.zhangfeng.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadLoaclDemo2
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 22:00
 */
class MyData{
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);
    public void add(){
        threadLocal.set(threadLocal.get() + 1);
    }

    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            for(int i = 0; i < 10 ; i++){
                service.submit(()->{
                    try {
                        Integer before = myData.threadLocal.get();
                        System.out.println(Thread.currentThread().getName() + "before  " + before);
                        myData.add();
                        Integer after = myData.threadLocal.get();
                        System.out.println(Thread.currentThread().getName() + " after " + after);
                    } finally {
                        myData.threadLocal.remove();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }
}


public class ThreadLoaclDemo2 {
}
