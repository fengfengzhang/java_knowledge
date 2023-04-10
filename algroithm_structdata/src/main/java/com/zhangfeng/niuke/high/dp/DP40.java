package com.zhangfeng.niuke.high.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DP40
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/10 14:59
 */
public class DP40 {
    /**
     * 小红拿到了一个数组，她想取一些数使得取的数之和尽可能大，但要求这个和必须是
     * �
     *
     * k  的倍数。
     * 你能帮帮她吗？
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextLong();
        }

        System.out.println(process(arr,k));
    }

    public static long process(long[] arr ,int k){

        //前i个数取和余数是k的时候的最大值
        long[][] dp = new long[arr.length][k];
       /* for(long[] a : dp){
            Arrays.fill(a,Long.MIN_VALUE);
        }*/

        for(int i = 0; i < k ; i++){
            dp[0][i] = (arr[0] % k == i) ? arr[0] : 0;
        }



        for(int i = 1; i < dp.length ; i++){
            for(int j = 0; j < k ; j++){
                dp[i][(int)((j + arr[i]) % k)] = Math.max(dp[i-1][j] + arr[i],dp[i-1][(int)((j + arr[i]) % k)]);
            }
        }

        if(dp[arr.length - 1][0] <= 0){
            return  -1;
        }


        return dp[arr.length-1][0];


    }


}


