package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName NC206
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/26 17:02
 */
public class NC206 {
    /**
     * 给定一个非负整数数组nums，假定最开始处于下标为0的位置，数组里面的每个元素代表下一跳能够跳跃的最大长度，如果可以跳到数组最后一个位置，请你求出跳跃路径中所能获得的最多的积分。
     * 1.如果能够跳到数组最后一个位置，才能计算所获得的积分，否则积分值为-1
     * 2.如果无法跳跃(即数组长度为0)，也请返回-1
     * 3.数据保证返回的结果不会超过整形范围，即不会超过
     * 2
     * 31
     * −
     * 1
     * 2
     * 31
     *  −1
     */
    public int maxJumpGrade (int[] nums) {
        // write code here
        if(nums == null || nums.length == 0) return -1;

        //从当前位置跳到最后的最大分数
        int[] dp = new int[nums.length];

        //能跳到最后位置的最小位置，越小往后面积累的数字就可能越大。
        int pos = nums.length - 1;
        dp[pos] = nums[pos];
        for(int i = nums.length - 2; i >= 0 ; i--){
            if(nums[i] + i >= pos){
                dp[i] = nums[i] + dp[pos];
                pos = i;
            }
        }

        return pos == 0 ? dp[0] : -1;

    }

    //o(n^2)的复杂度
    private int process(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        boolean flag;
        for(int i = 1; i < nums.length ; i++){
            flag = false;
            for(int j = i - 1 ;j >=0 ; j--){
                if(nums[j] + j >= i){
                    flag = true;
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            if(flag){
               dp[i] += nums[i];
            }else {
                return  -1;
            }
        }

        return  dp[nums.length -1] ;
    }

    public static void main(String[] args) {
        NC206 nc206 = new NC206();
        int[] arr =new int[100000];
        Arrays.fill(arr,1);
        System.out.println(nc206.maxJumpGrade(arr));
    }

}
