package com.zhangfeng.leetcode;

public class LeetCode416 {
    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */

    public boolean canPartition(int[] nums) {

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
            min = Math.min(min,sum);
        }

        if((sum &1) == 1){
            return false;
        }

        boolean[][] dp = new boolean[nums.length][sum + 1];
        int target = sum/2;


        dp[0][nums[0]] = true;
        for( int i = 1; i < nums.length ; i++){
            for (int j = min; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
                }

                if (dp[i][target]) {
                    return true;
                }
            }
            dp[i][nums[i]] = true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode416().canPartition(new int[]{3,3,6,8,16,16,16,18,20}));
    }



}
