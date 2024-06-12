package com.zhangfeng.niuke.high.frequency;

public class NC108 {
    /**
     * 给定一个由 '0' 和 '1' 组成的2维矩阵，返回该矩阵中最大的由 '1' 组成的正方形的面积。输入的矩阵是字符形式而非数字形式。
     *
     * 数据范围：矩阵的长宽满足
     * 0
     * ≤
     * 𝑛
     * ≤
     * 20
     * 0≤n≤20,矩阵中的元素属于 {'1','0'}
     * 进阶：空间复杂度
     * 𝑂
     * (
     * 𝑛
     * 2
     * )
     * O(n
     * 2
     *  ) ， 时间复杂度
     * 𝑂
     * (
     * 𝑛
     * 2
     * )
     * O(n
     * 2
     *  )
     */
    public int solve (char[][] matrix) {
        // write code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0){
            return 0;
        }

        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i =0 ;i < dp.length;i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(res,dp[i][0]);
        }

        for(int i = 0 ;i < dp[0].length ; i++){
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            res = Math.max(res,dp[0][i]);
        }

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1; j < dp[i].length ; j++){
                if(matrix[i][j] == '1'){
                   dp[i][j] =  Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }

        return res * res;

    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
        };

        System.out.println(new NC108().solve(matrix));
    }

}
