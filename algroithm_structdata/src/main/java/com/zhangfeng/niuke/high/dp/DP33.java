package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP33
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/4 19:35
 */
public class DP33 {

    /**
     * 假设你有一个数组
     * �
     * �
     * �
     * �
     * �
     * �
     * prices，长度为
     * �
     * n，其中
     * �
     * �
     * �
     * �
     * �
     * �
     * [
     * �
     * ]
     * prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
     * 1. 你最多可以对该股票有
     * �
     * k笔交易操作，一笔交易代表着一次买入与一次卖出，但是再次购买前必须卖出之前的股票
     * 2. 如果不能获取收益，请返回0
     * 3. 假设买入卖出均无手续费
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n ; i++){
            prices[i] = scanner.nextInt();
        }

        int[][] dp = new int[prices.length][2 * k + 1];
        for(int i = 0; i < dp[0].length ; i++){
            if((i &1) ==0){
                dp[0][i] = 0;
            }else{
                dp[0][i] = - prices[0];
            }
        }

        for(int i = 1 ; i < dp.length ; i++){

            for(int j = 1 ; j < dp[i].length ; j++){
                if((j&1) == 0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] + prices[i]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] - prices[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < dp[0].length ; i++){
          max = Math.max(max,dp[prices.length - 1][i]);
        }

        System.out.println(max);


    }

}
