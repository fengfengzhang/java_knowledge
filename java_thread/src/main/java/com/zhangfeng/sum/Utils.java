package com.zhangfeng.sum;

import java.util.Random;

/**
 * @ClassName Uitls
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 18:00
 */
public class Utils {
    //计算数组一段区间的和
    public static long sumRange(int[] arr, int low ,int high){
        long result = 0;
        for(int i = low; i < high ; i++){
            result += arr[i];
        }

        return result;
    }

    //随机生成整数数组
    public static int[] buildRandomIntArray(final int size){
        int[] arrayToCalculateSumOf = new int[size];
        Random random = new Random();
        for(int i = 0; i < arrayToCalculateSumOf.length ; i++){
            arrayToCalculateSumOf[i] = random.nextInt(1000);
        }
        return arrayToCalculateSumOf;
    }

}
