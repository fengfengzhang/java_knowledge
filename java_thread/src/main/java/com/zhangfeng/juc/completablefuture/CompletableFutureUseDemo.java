package com.zhangfeng.juc.completablefuture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CompletableFutureUseDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 15:51
 */
public class CompletableFutureUseDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        future2();

        Student student = new Student();
        student.setId(12).setStudentName("lisi").setMajor("cs");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });

        //join和get作用一样，但是不会在编译期抛出异常
        System.out.println(completableFuture.join());

    }

    private static void future2() throws InterruptedException {
        //默认的ForkJoinPool 和守护线程类似，main线程结束，就自动关闭了
        CompletableFuture.supplyAsync(() -> {
             System.out.println(Thread.currentThread().getName());
             int result = ThreadLocalRandom.current().nextInt(20);
             try {
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
 //            int i = 1/0;
            return result;

         }).whenComplete((v,e)->{
             if(e == null){
                 System.out.println("计算完成");
             }
        }).exceptionally(e ->{
            e.printStackTrace();
            System.out.println("异常"+e.getMessage());
            return null;
        });


        System.out.println("main ----");

        TimeUnit.SECONDS.sleep(3);
    }

    private static void future1() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "进入");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        });

        System.out.println("main-----");

        System.out.println(completableFuture.get());
    }
}

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
class Student{
    private Integer id;
    private String studentName;
    private String major;
}
