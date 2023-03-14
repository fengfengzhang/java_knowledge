package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution61
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 11:12
 */
public class Solution61 {

    /**
     * JZ63
     * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
     * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
     * 2.如果不能获取到任何利润，请返回0
     * 3.假设买入卖出均无手续费
     */
    public int maxProfit (int[] prices) {
        // write code here
        if(prices == null || prices.length == 0) return 0;
        int maxValue = 0;
        int preMin = prices[0];
        for(int i = 1; i < prices.length ; i++){
            maxValue = Math.max(maxValue , prices[i] - preMin);
            if(preMin > prices[i]){
                preMin = prices[i];
            }
        }
        return maxValue;
    }
}
