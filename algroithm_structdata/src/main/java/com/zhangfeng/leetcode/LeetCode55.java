package com.zhangfeng.leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode55
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/10/27 15:51
 */
public class LeetCode55 {

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length ];
        dp[nums.length - 1] = nums.length - 1;

        for(int i = nums.length - 2 ; i >= 0 ;i--){

            for(int j = i + 1; j <= i + nums[i] && j <= nums.length -1 ; j++){
                dp[i] = Math.max(dp[i], dp[j]);

            }
        }



        return dp[0] >= nums.length - 1;

    }

    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();
        System.out.println(leetCode55.canJump(new int[]{2, 3, 1, 1, 4}));
    }

}