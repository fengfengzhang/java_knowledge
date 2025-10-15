package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode74
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/10/15 17:40
 */
public class LeetCode74 {

    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int i = 0;
        int j = matrix[0].length - 1;

        while (i >=0 && i < matrix.length && j >=0 && j < matrix[0].length){

            if (matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else {
                i ++;
            }
        }

        return false;

    }

}