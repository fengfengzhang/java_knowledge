package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC143
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 11:19
 */
public class NC143 {
    /**
     * 假设你有一个数组prices，长度为n，其中prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
     * 1. 你可以多次买卖该只股票，但是再次购买前必须卖出之前的股票
     * 2. 如果不能获取收益，请返回0
     * 3. 假设买入卖出均无手续费
     *
     * 数据范围： 1 \le n \le 1 \times 10^51≤n≤1×10
     * 5
     *   ， 1 \le prices[i] \le 10^41≤prices[i]≤10
     * 4
     *
     * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
     * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     */
   /* public int maxProfit (int[] prices) {
        // write code here

        int[] dp = new int[prices.length];
        for(int i = 1; i< prices.length ; i++){
            //第i天不操作
            dp[i] = dp[i-1];
            for(int j = 0; j <= i - 1 ; j++){
                int temp = (prices[i] - prices[j]) +  ((j - 1) >= 0 ? dp[j-1] : 0);
                dp[i] = Math.max(dp[i],temp);
            }
        }
        return dp[prices.length -1];
    }
*/



    //或者采用贪心算法只要是递增段就会有收益
    public int maxProfit (int[] prices){
        //只要单调递增就有收益
        int res = 0;
        for(int i = 1; i < prices.length ; i++){
            if(prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices){
        int[][] dp = new int[prices.length][2];
        //今天买入，或者不操作（持有），到目前为止最大收益
        dp[0][0] = -prices[0];
        //今天卖出，或者不操作（不持有），为止最大收益
        dp[0][1] = 0;
        for(int i = 1; i < prices.length ; i++){
            //今天买入,i-1天卖出的最大收益-prices[i] 或者今天我不操作
            dp[i][0] = Math.max(dp[i-1][0] ,dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i],dp[i-1][1]);
        }
        return dp[prices.length -1][1];
    }

    public static void main(String[] args) {
        System.out.println(new NC143().maxProfit2(new int[]{8, 9, 2, 5, 4, 7, 1}));
    }
}
