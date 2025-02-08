package com.zhangfeng.juejin;

import java.util.Arrays;

public class Solution313 {

    public static int solution(int n, int[] weights, int[] values, int m) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int[][] dp = new int[m+1][n];

        for(int i = 0 ; i < m + 1; i++){
            if( i >= weights[0]){
                dp[i][0] = values[0];
            }
        }


        for(int i = 1 ;i  < m + 1; i ++){
            for(int j = 0; j < n ;j++){
                //当前商品要
                if(weights[j] <= i){
                    dp[i][j] = values[j] + ( j > 0 ?  dp[i - weights[j]][j-1] : 0);
                }

                //当前不要
                dp[i][j] = Math.max(j > 0 ? dp[i][j-1] : 0 ,dp[i][j]);
            }
        }



        return dp[m][n-1];
    }


    public static void main(String[] args) {

        System.out.println(solution(3, new int[]{2, 1, 3}, new int[]{4, 2, 3}, 3) == 6);
        System.out.println(solution(4, new int[]{1, 2, 3, 2}, new int[]{10, 20, 30, 40}, 5) == 70);
        System.out.println(solution(2, new int[]{1, 4}, new int[]{5, 10}, 4) == 10);
    }
}
