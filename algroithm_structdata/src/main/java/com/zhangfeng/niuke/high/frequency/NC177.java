package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC177
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 21:39
 */
public class NC177 {
    /**
     * 你是一个经验丰富的小偷，准备偷沿湖的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家，如果偷了第二家，那么就不能偷第一家和第三家。沿湖的房间组成一个闭合的圆形，即第一个房间和最后一个房间视为相邻。
     * 给定一个长度为n的整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
     */
    public int rob (int[] nums) {
        // write code here
        if(nums == null) return 0;

       int[][] dp = new int[nums.length][2];
       dp[0][0] = 0;
       dp[0][1] = nums[0];
       for(int i = 1; i< nums.length ; i++){
           dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
           dp[i][1] = nums[i] + dp[i-1][0];
       }

       int sum1 = dp[nums.length -1][0];
       dp[0][1] = 0;
        for(int i = 1; i< nums.length ; i++){
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        int sum2 = dp[nums.length -1][1];
        return Math.max(sum1,sum2);

    }
}
