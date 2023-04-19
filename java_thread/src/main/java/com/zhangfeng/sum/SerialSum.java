package com.zhangfeng.sum;

import java.time.Duration;
import java.time.Instant;

/**
 * @ClassName SerialSum
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 18:01
 */
public class SerialSum {

    public static long sum(int[] arr){
        long result = Utils.sumRange(arr,0, arr.length);
        return  result;
    }
}
