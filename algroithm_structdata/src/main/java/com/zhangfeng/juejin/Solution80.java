package com.zhangfeng.juejin;

public class Solution80 {
    /*
     小R近期表现出色，公司决定以股票的形式给予奖励，并允许他在市场上进行交易以最大化收益。给定一个数组，数组中的第 i 个元素代表第 i 天的股票价格。小R需要设计一个算法来实现最大利润。

股票交易规则如下：

小R可以多次买卖股票，但在买入新的股票前必须卖出之前的股票。
每次卖出股票后存在一天的冷冻期，在冷冻期内小R不能购买股票。
你的任务是帮助小R计算出在遵守交易规则的情况下能够获得的最大利润。

stocks: 一个整数列表，表示连续几天内的股票价格。

     */

    public static int solution(int[] stocks) {
        // Please write your code here


        if(stocks.length ==0){
            return 0;
        }

        int[][] dp = new int[stocks.length][3];


        dp[0][0] = -stocks[0]; //持有股票
        dp[0][1] = 0; //卖
        dp[0][2] = 0; //处于冷静期

        for(int i =1 ;i < stocks.length ; i++){
          dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - stocks[i]); //前一天持有，或者前一天是冷静期现在持有
          dp[i][1] = dp[i-1][0] + stocks[i];
          dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }


        return  Math.max(dp[stocks.length-1][1],dp[stocks.length-1][2]);

    }


    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();

        System.out.println(solution80.solution(new int[]{1, 6, 2, 7, 13, 2, 8}));

    }
}
