package com.zhangfeng.juc.completablefuture;


import java.util.concurrent.*;

/**
 * @ClassName CompletableFutureApi
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 16:43
 */
public class CompletableFutureApi {


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        m1();
//        m2();
//        m3();

//        m4();

//        m5();

//        m6();

//        m7();

//        m8();


    }

    private static void m8() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        CompletableFuture<Integer> future = future1.thenCombine(future2, (x, y) -> {
            System.out.println("开始两个结果和并");
            return x + y;
        });

        System.out.println(future.get());
    }

    private static void m7() throws InterruptedException, ExecutionException {
        CompletableFuture<String> playA = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playA";
        });
        CompletableFuture<String> playB = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playB";
        });

        CompletableFuture<String> completableFuture = playA.applyToEither(playB, f -> {
            return f + "is winer";
        });

        System.out.println(completableFuture.get());
    }

    private static void m6() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "aa";
        },executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(completableFuture.get());
    }

    private static void m5() {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            return "a";
        }).thenRun(() -> {
            System.out.println("b");
        }).join());

        System.out.println(CompletableFuture.supplyAsync(() -> {
            return "a";
        }).thenAccept(System.out::println).join());

        System.out.println(CompletableFuture.supplyAsync(() -> {
            return "a";
        }).thenApply(f->f + "b").join());
    }

    private static void m4() throws InterruptedException {
        CompletableFuture.supplyAsync(()-> 1).thenApply(f-> f + 1).thenApply(f-> f + 3).thenAccept(System.out::println);

        TimeUnit.SECONDS.sleep(2);
    }

    //有异常可以带着异常继续往下走
    private static void m3() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;

        },executorService).handle((f,e)-> {
            int i = 1/0;
            System.out.println("222");
            return f + 2;
        }).handle((f,e)->{
            System.out.println("333");
            return f+3;
        }).whenComplete((v,e)->{
            if(e== null){
                System.out.println("计算结果" + v);
            }
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return null;
        });
    }


    //有异常就断了
    private static void m2() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;

        }, executorService).thenApply(f -> {
            System.out.println("222");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果" + v);
            }
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return null;
        });
    }

    private static void m1() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "abc";
        });

//        System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
//        System.out.println(completableFuture.join());
//        System.out.println(completableFuture.get());
        //没计算完成给一个默认值
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(completableFuture.getNow("xxx"));

        //打断并给结果默认值
        System.out.println(completableFuture.complete("xxx") + "-----"+completableFuture.join());
    }

}
