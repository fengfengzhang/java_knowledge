package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP25
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/23 14:19
 */
public class DP25 {
    /**
     * 给定一个长度为 n 的仅包含正整数的数组，另外有一些操作，每次操作你可以选择数组中的任意一个元素
     * �
     * �
     *
     * a
     * i
     * ​
     *    ，同时数组中所有等于
     * �
     * �
     * −
     * 1
     *
     * a
     * i
     * ​
     *  −1  和
     * �
     * �
     * +
     * 1
     *
     * a
     * i
     * ​
     *  +1  的元素会被全部移除，同时你可以得到
     * �
     * �
     *
     * a
     * i
     * ​
     *    分，直到所有的元素都被选择或者删除。
     * 请你计算最多能得到多少分。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        int[] tran = new int[10001];
        for(int i = 0; i < arr.length ; i++){
            tran[arr[i]] += arr[i];
        }

        /*int[] dp = new int[tran.length];
        dp[0] = tran[0];
        for(int i = 1; i < tran.length ; i++){
            dp[i] = Math.max(dp[i-1], (i>=2 ? dp[i-2] : 0) + tran[i]);
        }

        System.out.println(dp[tran.length -1]);*/

        int[][] dp = new int[tran.length][2];

        dp[0][0] = 0;
        dp[0][1] = tran[0];
        for(int i = 1 ; i < tran.length ; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + tran[i];
        }

        System.out.println(Math.max(dp[tran.length -1][0],dp[tran.length-1][1]));


    }





}
