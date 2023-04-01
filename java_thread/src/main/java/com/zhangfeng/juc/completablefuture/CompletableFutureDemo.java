package com.zhangfeng.juc.completablefuture;

import java.util.concurrent.*;

/**
 * @ClassName CompletableFuture
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 14:54
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        m1();
       FutureTask<String> futureTask = new FutureTask<>(()->{
           TimeUnit.SECONDS.sleep(7);
           return "callable";
       });

        new Thread(futureTask).start();

        //阻塞获取结果
//        System.out.println(futureTask.get());
//        System.out.println(futureTask.get(1,TimeUnit.SECONDS));

        //轮询耗费cpu资源
        while (true){
            if(futureTask.isDone()){
                System.out.println(futureTask.get());
                break;
            }else{
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("计算中.....");
            }
        }


        System.out.println("main 方法");

    }

    private static void m1() throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask,"t1");
        t1.start();
        System.out.println(futureTask.get());
    }

}


class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("------come in call() ");
        return "hello callable";
    }
}
/**
 * 1.get() 容易程序阻塞。
 * 2.假如不愿意等待很长时间,get(int i, TimeUnit)
 */


