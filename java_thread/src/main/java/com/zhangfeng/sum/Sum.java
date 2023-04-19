package com.zhangfeng.sum;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @ClassName Sum
 * @Description 1亿个数求和
 * @Author zhangfeng
 * @Date 2023/4/19 17:49
 */
public class Sum {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int[] arr = Utils.buildRandomIntArray(210000000);
//        IntStream intStream = IntStream.rangeClosed(0, 210000000);
//        int[] arr = intStream.toArray();

        long start = System.currentTimeMillis();
        long result1 = SerialSum.sum(arr);
        long end = System.currentTimeMillis();
        System.out.println("result1: " + result1 + " time : " + (end -start));


        start = System.currentTimeMillis();
        long result2 = ExecutorSum.sum(arr, executorService);
        end = System.currentTimeMillis();
        System.out.println("result2: " + result2 + " time : " + (end -start));
        executorService.shutdown();


        start = System.currentTimeMillis();
        long result3 = forkJoinPool.invoke(new ForkJoinCalculate(0,arr.length,arr));
        end = System.currentTimeMillis();
        System.out.println("result3: " + result3 + " time : " + (end -start));
        forkJoinPool.shutdown();


        start = System.currentTimeMillis();
        long result4 = Arrays.stream(arr).asLongStream().parallel().sum();
//        long result4 = LongStream.rangeClosed(0, 210000000).parallel().sum();
        end = System.currentTimeMillis();
        System.out.println("result4: " + result4 + " time : " + (end -start));


        start = System.currentTimeMillis();
        CompletableFutureSum completableFutureSum = new CompletableFutureSum(0, arr.length, arr);
        long result5 = completableFutureSum.sum();
        end = System.currentTimeMillis();
        System.out.println("result5: " + result5 + " time : " + (end -start));



    }


}
