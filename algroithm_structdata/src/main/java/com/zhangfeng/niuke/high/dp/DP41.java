package com.zhangfeng.niuke.high.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DP41
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/4 19:55
 */
public class DP41 {
    /**
     * 你有一个背包，最多能容纳的体积是V。
     *
     * 现在有n个物品，第i个物品的体积为
     * �
     * �
     * v
     * i
     * ​
     *   ,价值为
     * �
     * �
     * w
     * i
     * ​
     *  。
     *
     * （1）求这个背包至多能装多大价值的物品？
     * （2）若背包恰好装满，求至多能装多大价值的物品？
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] vArr = new int[n];
        int[] wArr = new int[n];
        for(int i = 0; i < n ; i++){
            vArr[i] = scanner.nextInt();
            wArr[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][v + 1];

        for(int i = 1; i < dp.length ; i++){
            for(int j = 1; j < dp[0].length ; j++){
                if(vArr[i-1] <= j){
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i-1][j-vArr[i-1]] + wArr[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }


        int[][] dp2 = new int[n+1][v + 1];
        for(int[] a : dp2){
            Arrays.fill(a,Integer.MIN_VALUE);
        }

        for(int i = 0; i < dp2.length ; i++){
            dp2[i][0] = 0;
        }

        for(int i = 1; i < dp2.length ; i++){
            for(int j = 1; j < dp2[0].length ; j++){
                if(vArr[i-1] <= j){
                    dp2[i][j] = vArr[i-1] == j ? wArr[i-1] : dp2[i][j];
                    if(vArr[i-1] < j && dp2[i-1][j-vArr[i-1]] > 0){
                        dp2[i][j] = Math.max(dp2[i][j],dp2[i-1][j-vArr[i-1]] + wArr[i-1]);
                    }

                }
                dp2[i][j] = Math.max(dp2[i-1][j],dp2[i][j]);

            }
        }

        System.out.println(dp[n][v]);
        System.out.println(Math.max(dp2[n][v], 0));

    }

}
