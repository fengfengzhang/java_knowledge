package com.zhangfeng.niuke.high.frequency;

public class NC214 {
    /**
     * 给定一个只包含正整数的数组 nums ，请问能否把这个数组取出若干个数使得取出的数之和和剩下的数之和相同。
     *
     * 数据范围：
     * 1
     * ≤
     * 𝑛
     * ≤
     * 500
     *
     * 1≤n≤500  ， 数组中的元素满足
     * 1
     * ≤
     * 𝑛
     * 𝑢
     * 𝑚
     * 𝑠
     * 𝑖
     * ≤
     * 100
     *
     * 1≤nums
     * i
     * ​
     *  ≤100
     *  [1,5,11,5]
     * @param nums
     * @return
     */

    public boolean partition (int[] nums) {
        // write code here
        int sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
        }

        if((sum & 1) != 0){
            return false;
        }

        int halfNum = sum / 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];

        for(int i = 0; i < dp.length ; i++){
            for(int j = 0; j < dp[i].length ; j++){
               if(nums[i] > j){
                   continue;
               }
                if(j == nums[i] || dp[i][j-nums[i]]){
                    dp[i][j] = true;
                }

                if(j == halfNum && dp[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new NC214().partition(new int[]{1,5,11,5}));
    }
}
