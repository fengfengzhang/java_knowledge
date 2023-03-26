package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;

/**
 * @ClassName NC205
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/26 17:30
 */
public class NC205 {

    /**
     * 给定一个非负整数数组nums，假定最开始处于下标为0的位置，数组里面的每个元素代表下一跳能够跳跃的最大长度。请你判断最少跳几次能跳到数组最后一个位置。
     * 1.如果跳不到数组最后一个位置或者无法跳跃(即数组长度为0)，请返回-1
     * 2.数据保证返回的结果不会超过整形范围，即不会超过
     * 2
     * 31
     * −
     * 1
     * 2
     * 31
     *  −1
     */

    public int minJumpStep (int[] nums) {
        // write code here
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        boolean flag;
        for(int i = nums.length - 2 ; i>=0 ; i--){
            flag = false;
            for(int j = nums[i]; j >= 1 ; j--){
                if(i+j >= nums.length-1){
                    dp[i] = 1;
                    break;
                }

                if(i+j < nums.length && dp[j + i] != Integer.MAX_VALUE) {
                    flag = true;
                    dp[i] = Math.min(dp[i], dp[i + j]);
                }
            }
            if(flag){
                dp[i] += 1;
            }

        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];

    }

    public static void main(String[] args) {
        NC205 nc205 = new NC205();
        System.out.println(nc205.minJumpStep(new int[]{2,3,1,1,4}));
    }
}
