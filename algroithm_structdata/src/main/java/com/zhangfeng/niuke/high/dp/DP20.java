package com.zhangfeng.niuke.high.dp;

import java.util.Scanner;

/**
 * @ClassName DP20
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/12 11:34
 */
public class DP20 {

    /**
     * 计算字符串的编辑距离
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length ; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i < dp[0].length ; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i < dp.length ; i++){
            for(int j = 1 ; j < dp[i].length ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
