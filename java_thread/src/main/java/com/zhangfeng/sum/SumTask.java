package com.zhangfeng.sum;

import java.util.concurrent.Callable;

/**
 * @ClassName SumTask
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 17:58
 */
public class SumTask implements Callable<Long> {
    int low;
    int high;
    int[] arr;

    public SumTask(int low, int high, int[] arr) {
        this.low = low;
        this.high = high;
        this.arr = arr;
    }

    @Override
    public Long call() throws Exception {

        long result = Utils.sumRange(arr, low, high);
        return result;
    }
}
