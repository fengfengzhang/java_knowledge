package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP23
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/10 16:06
 */
public class DP23 {

    /**
     * 小红拿到了一个数组。她想取一些不相邻的数，使得取出来的数之和尽可能大。你能帮帮她吗？
     */
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }

        int[][] dp = new int[arr.length][2];
        dp[0][0] = 0;
        dp[0][1] = arr[0];

        for(int i = 1; i < dp.length ;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + arr[i];
        }

        System.out.println(Math.max(dp[dp.length -1][0],dp[dp.length-1][1]));

    }

}
