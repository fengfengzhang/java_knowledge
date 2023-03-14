package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution69
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 17:43
 */
public class Solution69 {

    /**
     * JZ71
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
     */
    public int jumpFloorII(int target) {
       /* int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2; i< dp.length ; i ++){
            for(int j = 0 ; j < i ; j++){
               dp[i] += dp[j];
            }
        }

        return dp[target];*/


        if (target <= 2) {
            return target;
        }
        int pre = 2;
        int cur = 0;


        for (int i = 3; i <= target ; i++) {

            cur = 2 * pre;
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution69().jumpFloorII(3));
    }


}
