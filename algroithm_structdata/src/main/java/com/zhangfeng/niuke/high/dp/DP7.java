package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP7
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/10 15:34
 */
public class DP7 {
    /**
     * 输入一个长度为 n 的整型数组 nums，数组中的一个或连续多个整数组成一个子数组。求所有子数组的乘积的最大值。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i= 0;i < n ; i++){
            arr[i] = scanner.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        int res = arr[0];
        int tempMin;
        int tempMax;
        for(int i = 1; i < arr.length ; i++){
            tempMin = min * arr[i];
            tempMax = max * arr[i];
            max = Math.max(Math.max(tempMin,arr[i]),tempMax);
            min = Math.min(Math.min(tempMax,arr[i]),tempMin);
            res = Math.max(res,max);
        }
        System.out.println(res);
    }
}
