package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution45
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 12:09
 */
public class Solution45 {
    /**
     * JZ47
     * 在一个m\times nm×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * 如输入这样的一个二维数组，
     */
    public int maxValue (int[][] grid) {
        // write code here
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < dp.length ; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1 ; i < dp[0].length ; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i = 1 ; i < dp.length ; i++){
            for (int j =1 ; j < dp[i].length ; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length -1];

    }

    public static void main(String[] args) {
        int[][] arr = {{9,1,4,8}};
        System.out.println(new Solution45().maxValue(arr));
    }

}
