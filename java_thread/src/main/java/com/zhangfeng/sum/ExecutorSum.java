package com.zhangfeng.sum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @ClassName ExecutorSum
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 18:03
 */
public class ExecutorSum {
    public final static int NUM = 10000000;

    public static long sum(int[] arr, ExecutorService executor) throws ExecutionException, InterruptedException {
        long result = 0;
        int numThreads = arr.length / NUM > 0 ? arr.length / NUM : 1;
        SumTask[] tasks = new SumTask[numThreads];
        Future<Long>[] sums = new Future[numThreads];

        for(int i = 0; i < numThreads ; i++){
            int high = i == numThreads-1 ?  Math.max((i+1)*NUM,arr.length) : (i+1)*NUM;
            tasks[i] = new SumTask(i*NUM, high,arr);
           sums[i] = executor.submit(tasks[i]);
        }

        for(int i = 0; i < sums.length ; i++){
            result += sums[i].get();
        }

        return result;
    }
}
