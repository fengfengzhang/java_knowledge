package com.zhangfeng.niuke.high.frequency;

public class BM64 {

    /**
     * 给定一个整数数组
     * 𝑐
     * 𝑜
     * 𝑠
     * 𝑡
     *
     * cost  ，其中
     * 𝑐
     * 𝑜
     * 𝑠
     * 𝑡
     * [
     * 𝑖
     * ]
     *
     * cost[i]  是从楼梯第
     * 𝑖
     *
     * i 个台阶向上爬需要支付的费用，下标从0开始。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     *
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * 请你计算并返回达到楼梯顶部的最低花费。
     */

    public int minCostClimbingStairs (int[] cost) {
        // write code here
        if(cost.length <= 2){
            return 0;
        }

        int preCost = 0;
        int curCost = 0;

        int culCost = 0;

        for(int i = 2 ;i  < cost.length + 1 ; i++){
            culCost = Math.min(curCost + cost[i-1],preCost + cost[i-2]);
            preCost = curCost;
            curCost = culCost;
        }

        return culCost;

    }

    public static void main(String[] args) {
        BM64 bm64 = new BM64();
        System.out.println(bm64.minCostClimbingStairs(new int[]{2,5,20}));
    }
}
