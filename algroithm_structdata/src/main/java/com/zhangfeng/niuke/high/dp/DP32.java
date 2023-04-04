package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP32
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/4 15:52
 */
public class DP32 {

    /**
     * 假设你有一个数组prices，长度为n，其中prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
     * 1. 你最多可以对该股票有两笔交易操作，一笔交易代表着一次买入与一次卖出，但是再次购买前必须卖出之前的股票
     * 2. 如果不能获取收益，请返回0
     * 3. 假设买入卖出均无手续费
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n ; i++){
            prices[i] = scanner.nextInt();
        }
        System.out.println(process(prices));

    }


    public static int process(int[] prices){
        if(prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][3] = - prices[0];

        for(int i = 1; i < prices.length ; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }


        return Math.max(Math.max(dp[prices.length -1][0],dp[prices.length -1][2]),dp[prices.length-1][4]);

    }




}
