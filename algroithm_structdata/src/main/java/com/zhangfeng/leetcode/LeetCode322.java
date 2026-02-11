package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode322
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/11 16:32
 */
public class LeetCode322 {
    /**
     *
     * 零钱兑换
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     *
     * @param coins
     * @param amount
     * @return
     */

    public int coinChange(int[] coins, int amount) {
        int res = process(coins, amount);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }

    public int process2(int[] coins, int amount){
        if(amount <0){
            return Integer.MAX_VALUE;
        }
        if(amount == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length ; i++){
            if(amount >= coins[i]){
                int result = process2(coins, amount - coins[i]);
                if(result != Integer.MAX_VALUE){
                    min = Math.min(result + 1,min);
                }
            }
        }
        return min;
    }


    public int process(int[] coins, int amount ){
        int[] dp = new int[amount + 1];
        for(int i = 1 ; i < dp.length ; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 0; j < coins.length ; j++){
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }

            }
        }


        if(dp[amount] == Integer.MAX_VALUE){
            return  -1;
        }


        return  dp[amount];



    }

}