package com.zhangfeng.sum;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName CompleteableFutureSum
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 18:47
 */
class CompletableFutureSum {
    int low;
    int high;
    int[] arr;
    public final static int NUM = 10000000;

    public CompletableFutureSum(int low, int high, int[] arr) {
        this.low = low;
        this.high = high;
        this.arr = arr;
    }

    public long sum(){
        int num = arr.length / NUM > 0 ? arr.length / NUM : 1;
        CompletableFuture<Long>[] completableFutures = new CompletableFuture[num];
        for(int i = 0 ;i < num; i++){
            int index = i;
            completableFutures[i]= CompletableFuture.supplyAsync(() -> {
                int high = index == num-1 ?  Math.max((index+1)*NUM,arr.length) : (index+1)*NUM;
                return Utils.sumRange(arr, index * NUM, high);
            });
        }
        CompletableFuture<Long> future = completableFutures[0];
        for(int i = 1; i < completableFutures.length ; i++){
            future = future.thenCombine(completableFutures[i],(x,y)->{
                return x + y;
            });
        }
        return future.join();




    }
}
