package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP14
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/20 23:20
 */
public class DP14 {
    /**
     * 给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
     * 所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        //必须以i位置结尾的最长公共子序长度
        int[] dp = new int[n];
        dp[0] = 1;
        int length = 1;
        for(int i = 1; i < dp.length ; i++){
            dp[i] = 1;
            for(int j = i - 1 ;j >= 0; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            length = Math.max(length,dp[i]);
        }
        System.out.println(length);

    }

}
