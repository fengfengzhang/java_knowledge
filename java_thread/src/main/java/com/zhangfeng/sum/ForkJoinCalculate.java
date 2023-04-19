package com.zhangfeng.sum;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName RecursiveSumTask
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 18:14
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    public int start;
    public int end;
    public int[] arr;
    public final static int NUM = 10000000;

    public ForkJoinCalculate(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }


    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= NUM){
            long result = 0;
            for(int i = start; i< end;i++){
                result += arr[i];
            }
            return result;
        }else{
          int middle =  (start + end)/2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle,arr);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(middle, end, arr);
            right.fork();
            return left.join() + right.join();
        }


    }
}
