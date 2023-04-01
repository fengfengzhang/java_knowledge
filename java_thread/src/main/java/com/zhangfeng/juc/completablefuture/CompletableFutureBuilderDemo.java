package com.zhangfeng.juc.completablefuture;

import java.util.concurrent.*;

/**
 * @ClassName CompletableFutureBulderDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 15:41
 */
public class CompletableFutureBuilderDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


    }

    private static void m2() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "completable";
        },executorService);


        System.out.println(completableFuture.get());
    }

    private static void m1() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //如果没有指定就用默认，
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executorService);
    }
}
