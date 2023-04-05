package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC203
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/5 12:07
 */
public class NC203 {

    /**
     * 给定一个整数数组 nums 表示不同数额的硬币和一个正整数 target 表示总金额，请你计算并返回可以凑出总金额的的组合数。如果凑不出 target 则返回 0。
     */
    public int change (int target, int[] nums) {
        // write code here
        if(nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length + 1][target + 1];
        for(int i = 0; i < dp.length ; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length ; i++){
            for(int j = 1; j < dp[i].length ;j++){
                if(j >= nums[i-1]) {
                    for (int k = 1; k <= j / nums[i - 1]; k++) {
                        dp[i][j] += dp[i - 1][j - k * nums[i - 1]];
                    }
                    dp[i][j] += dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }


            }
        }

        return dp[nums.length][target];

    }

    public static void main(String[] args) {
        NC203 nc203 = new NC203();
        System.out.println(nc203.change(5, new int[]{1, 2, 4, 5}));
    }

}
