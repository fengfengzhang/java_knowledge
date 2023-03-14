package com.zhangfeng.juc.atomic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ProductConsumer_BlockQueueDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 13:56
 */
class MyResource{
    public volatile boolean FLAG = true; //开启进行生产消费
    private final AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProduct() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
           data = String.valueOf(atomicInteger.incrementAndGet());
           retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
           if(retValue){
               System.out.println(Thread.currentThread().getName() + "当前线程插入数据"+data);
           }else{
               System.out.println(Thread.currentThread().getName() + "当前线程插入数据失败");

           }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "FLAG ="  + FLAG);
    }

    public void myConsumer() throws Exception{
        String data = null;
        while (FLAG){
           data = blockingQueue.poll(2L,TimeUnit.SECONDS);
           if(null == data || data.equalsIgnoreCase("")){
              FLAG = false;
              System.out.println(Thread.currentThread().getName() + "超过两秒没有取到数据消费退出");
              return;
           }
           System.out.println(Thread.currentThread().getName() + "当前线程消费数据"+data);

        }

        System.out.println(Thread.currentThread().getName() + "FLAG ="  + FLAG);

    }




}


public class ProductConsumer_BlockQueueDemo {



    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "生产启动");
            try {
                myResource.myProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "生产结束");
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "消费启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "消费结束");
        },"Consumer").start();

        TimeUnit.SECONDS.sleep(5);
        myResource.FLAG =false;

        System.out.println("main 线程叫停");
    }
}
