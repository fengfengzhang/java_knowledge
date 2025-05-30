package com.zhangfeng.leetcode;

public class LeetCode53 {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组是数组中的一个连续部分。
     * @param nums
     * @return
     */

    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = 0;
        for(int i = 0; i < nums.length ; i++){
            cur += nums[i];

            if(i == 0){
                max = cur;
            }else{
                max = Math.max(cur,max);
            }

            if(cur < 0){
                cur = 0;
            }
        }

        return max;
    }
}
