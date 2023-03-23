package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP19
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/23 14:08
 */
public class DP19 {
    /**
     * 给定两个字符串 s1 和 s2，长度为 n 和 m  。求两个字符串最长公共子序列的长度。
     * 所谓子序列，指一个字符串删掉部分字符（也可以不删）形成的字符串。例如：字符串 "arcaea" 的子序列有 "ara" 、 "rcaa" 等。但 "car" 、 "aaae" 则不是它的子序列。
     * 所谓 s1 和 s2 的最长公共子序列，即一个最长的字符串，它既是 s1 的子序列，也是 s2 的子序列。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        char[] s1 = scanner.nextLine().toCharArray();
        char[] s2 = scanner.nextLine().toCharArray();
        int[][] dp = new int[n][m];
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;

        for(int i = 1; i < dp.length;i++){
            if(dp[i-1][0] == 1 || s2[0] == s1[i]){
                dp[i][0] = 1;
            }
        }

        for(int i = 1; i < dp[0].length ; i++){
            if(dp[0][i-1] == 1 || s2[i] == s1[0]){
                dp[0][i] = 1;
            }
        }

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1; j < dp[i].length ; j++){
                if(s1[i] == s2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n-1][m-1]);

    }
}
