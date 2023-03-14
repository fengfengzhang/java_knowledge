package com.zhangfeng.juc.atomic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 16:44
 */


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("*******come in *****");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread myThread = new MyThread();
        //一个task只会被用一次，计计算完了。共用不会计算
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        Thread t1 = new Thread(futureTask);
        t1.start();
        while (!futureTask.isDone()){

        }
        System.out.println(futureTask.get());


    }

}
