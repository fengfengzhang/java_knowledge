package com.zhangfeng.juc.atomic;

/**
 * @ClassName BlockingQueueDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 11:49
 */

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 1.队列
 *
 * 2.阻塞队列
 *   2.1 阻塞队列有没有好的一面
 *
 *   2.2 不得不阻塞,你如何管理
 *
 */

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
       /* System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));


        System.out.println(blockingQueue.element());*/

        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());

    */

      /*  blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        System.out.println("======");
        //满了就阻塞
//        blockingQueue.put("a");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();*/

        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);

    }
}
