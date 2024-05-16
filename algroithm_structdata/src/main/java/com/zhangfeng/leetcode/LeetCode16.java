package com.zhangfeng.leetcode;

import java.util.Arrays;

public class LeetCode16 {
    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long res = Long.MAX_VALUE;
        for(int i = 0; i <= nums.length - 3 ; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){
                int temp = nums[i] + nums[start] + nums[end];
                if (res == Long.MAX_VALUE){
                    res = temp;
                }else {
                    res = Math.abs(temp - target) < Math.abs(res - target) ? temp : res;
                }
                if(temp == target){
                    return target;
                }else if(temp > target){
                     end --;
                }else{
                    start ++;
                }
            }

        }
        return  (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
