package com.zhangfeng.niuke.high.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DP10
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/4 16:08
 */
public class DP10 {
    /**
     *
     *  已知矩阵的大小定义为矩阵中所有元素的和。给定一个矩阵，你的任务是找到最大的非空(大小至少是1 * 1)子矩阵。 比如，如下4 * 4的矩阵 0 -2 -7 0 9 2 -6 2 -4 1 -4 1 -1 8 0 -2 的最大子矩阵是 9 2 -4 1 -1 8 这个子矩阵的大小是15。
     */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length ; j++){

                matrix[i][j] = scanner.nextInt();
            }

        }

        System.out.println(process(matrix));

    }


    public static  int process(int[][] matrix){
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] temp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length ; i++){

            Arrays.fill(temp,0);

            for(int j = i; j>=0 ; j--){
                cur = 0;
                for(int k = 0; k < matrix[i].length ; k++){
                    temp[k] += matrix[j][k];
                }

                for(int m = 0; m  < temp.length ; m ++){
                    cur += temp[m];
                    max = Math.max(cur,max);
                    if(cur < 0){
                        cur = 0;
                    }
                }

            }
        }

        return max;


    }


}
