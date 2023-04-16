package com.zhangfeng.niuke.high.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DP44
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/16 15:37
 */
public class DP44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int aim = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }

        if(aim == 0) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[n+1][aim +1];
        for(int[] a : dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

       /* for(int i = 0; i < dp.length ; i++){
            dp[i][0] = 0;
        }*/


        for(int i = 1; i < dp.length ; i++){
            for(int j = 1; j < dp[i].length ; j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(arr[i-1] == j){
                    dp[i][j] = 1;
                    continue;
                }
                if(j > arr[i - 1]){
                    for(int k = 1; k <= j/arr[i-1] ; k++){
                        if(dp[i][j- k*arr[i-1]] != Integer.MAX_VALUE){
                           dp[i][j] =Math.min(dp[i][j],dp[i][j- k*arr[i-1]] + k);
                        }
                    }
                }
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);
            }
        }

        System.out.println(dp[n][aim] == Integer.MAX_VALUE ? - 1 : dp[n][aim]);

    }
}
