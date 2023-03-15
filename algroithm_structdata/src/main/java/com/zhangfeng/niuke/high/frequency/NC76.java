package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC76
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 21:14
 */
public class NC76 {

    /**
     * 你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
     * 给定一个整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
     */

    public int rob (int[] nums) {
        // write code here

        return processByDp2(nums);
    }

    public int processByDp2(int[] nums){
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i < dp.length ; i++){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[nums.length -1][0],dp[nums.length-1][1]);
    }

    public int process(int[] nums , int i ,int j){
        if(i == j){
            return nums[i];
        }else if(i + 1 == j){
            return Math.max(nums[i],nums[j]);
        }else{
            return Math.max(
                    nums[i] + process(nums,i+2,j),
                    process(nums,i+1,j));
        }
    }


    public int processByDp(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        for(int j = 0; j < dp[0].length ; j++){
            for(int i = dp.length -1; i >= 0; i--){
                if(i > j) continue;
                if(i==j){
                    dp[i][j] = nums[i];
                }else if(i + 1 == j){
                    dp[i][j] = Math.max(nums[i],nums[j]);
                }else{
                     dp[i][j] = Math.max(nums[i] + dp[i+2][j],dp[i+1][j]);
                }
            }
        }
        return dp[0][nums.length -1];
    }

    public static void main(String[] args) {
       int[] arr = new int[]{1,2,3,4};
        System.out.println(new NC76().rob(arr));
    }


}
