package com.zhangfeng.leetcode;

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {

        for(int i = 0; i < nums.length  ;i ++){
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
                swap(nums,i,nums[i] - 1);
            }


        }

        int res = nums.length + 1;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != i + 1){
                res = i + 1;
                break;
            }
        }

        return res;

    }

    public void swap(int[]a ,int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode41().firstMissingPositive(new int[]{0,1,2}));
    }

}
