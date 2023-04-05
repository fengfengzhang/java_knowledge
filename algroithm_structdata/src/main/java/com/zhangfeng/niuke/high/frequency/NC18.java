package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;

/**
 * @ClassName NC18
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/5 12:20
 */
public class NC18 {
    /**
     * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
     *
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵。
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
       int[][] res = new int[mat.length][mat[0].length];


       int leftTop = 0;

       int rightDown = mat[0].length - 1;

       while (leftTop <= rightDown){

            for(int i = leftTop ;i <= rightDown ; i++){
                res[i][rightDown] = mat[leftTop][i];
            }
            int index = leftTop;
           for(int i = rightDown ; i>= leftTop ; i--){
               res[rightDown][i] = mat[index++][rightDown];
           }

           for(int i = leftTop ; i <= rightDown; i++){
               res[i][leftTop] = mat[rightDown][i];
           }
           index = leftTop;
           for(int i = rightDown ; i>= leftTop ; i--){
               res[leftTop][i] = mat[index ++][leftTop];
           }
           leftTop ++;
           rightDown --;
       }

       return  res;
    }

    public static void main(String[] args) {
        NC18 nc18 = new NC18();
        int[][] matrix = nc18.rotateMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3);

        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }
}
