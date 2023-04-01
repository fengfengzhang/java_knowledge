package com.zhangfeng.juc.completablefuture;

import java.util.concurrent.*;

/**
 * @ClassName FutureThreadPoolDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 15:07
 */
public class FutureThreadPoolDemo
{

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        m1();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();
        FutureTask<String> futureTask1 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(300);
            return "over";
        });
        FutureTask<String> futureTask2 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return "over";
        });

        executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        TimeUnit.MILLISECONDS.sleep(700);
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime " + (endTime - startTime));
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
    }

    private static void m1() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        TimeUnit.MILLISECONDS.sleep(300);
        TimeUnit.MILLISECONDS.sleep(500);
        TimeUnit.MILLISECONDS.sleep(700);

        long endTime = System.currentTimeMillis();

        System.out.println("----costTime " + (endTime - startTime));

        System.out.println(Thread.currentThread().getName() + "end");
    }
}
