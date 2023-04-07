package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP8
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/7 11:25
 */
public class DP8 {
    /**
     * 给定一个长度为 n 的整数数组，请你找出其中最长的乘积为正数的子数组长度。
     * 子数组的定义是原数组中一定长度的连续数字组成的数组。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }

        int[] dp = new int[n];

        int max = 0;
        for(int i = 0; i < dp.length ; i++){
           if(arr[i] > 0){
               dp[i] = (i > 0 ? dp[i-1] : 0) + 1;
           }else if (arr[i] == 0){
               dp[i] = 0;
           }else {
               if(i - 1 >= 0 && i - dp[i-1]-1 >= 0 && arr[i - dp[i-1] - 1] < 0){
                   dp[i] = dp[i-1] + 2;
                   dp[i] += i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0;

               }
           }

           max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }




}
