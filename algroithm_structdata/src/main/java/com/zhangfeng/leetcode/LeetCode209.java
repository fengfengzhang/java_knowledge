package com.zhangfeng.leetcode;

import java.util.LinkedList;

public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int res = nums.length + 1;
        while (right < nums.length && left < nums.length){
            sum += nums[right];

            while (sum >= target && right >= left){
                res = Math.min(right - left + 1,res);
                sum -= nums[left];
                left ++;
            }
            right ++;
        }

        if(res > nums.length ){
            res = 0;
        }

        return res;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        LeetCode209 leetCode209 = new LeetCode209();
        System.out.println(leetCode209.minSubArrayLen(15, arr));
    }

}
