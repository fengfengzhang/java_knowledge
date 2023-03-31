package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NC304
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/31 13:48
 */
public class NC304 {
    /**
     * 已知矩阵的大小定义为矩阵中所有元素的和。
     * 给定一个大小为N*N的矩阵，你的任务是找到最大的非空(大小至少是1 * 1)子矩阵。 比如，如下4 * 4的矩阵
     * 0 -2 -7 0
     * 9 2 -6 2
     * -4 1 -4 1
     * -1 8 0 -2 的最大子矩阵是
     * 9 2
     * -4 1
     * -1 8 这个子矩阵的大小是15。
     */
    public int getMaxMatrix (ArrayList<ArrayList<Integer>> matrix) {
        // write code here

        if(matrix == null || matrix.size() == 0) return 0;
        int[] temp = new int[matrix.get(0).size()];
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.size() ; i++){

            Arrays.fill(temp,0);
            for(int j = i ; j >= 0 ; j--){
                cur = 0;
                for(int k = 0 ; k < matrix.get(j).size() ; k++){
                    temp[k] += matrix.get(j).get(k);
                }

                for(int m = 0; m < temp.length ; m++){
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
