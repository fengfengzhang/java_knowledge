package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC127
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 10:45
 */
public class NC127 {
    /**
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
     * 题目保证str1和str2的最长公共子串存在且唯一。
     *
     * 数据范围： 1 \le |str1|,|str2| \le 50001≤∣str1∣,∣str2∣≤5000
     * 要求： 空间复杂度 O(n^2)O(n
     * 2
     *  )，时间复杂度 O(n^2)O(n
     * 2
     *  )
     */

    public String LCS (String str1, String str2) {
        if(str1 == null || str2 == null || "".equals(str1) || "".equals(str2))
            return "";
        // write code here
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;
        int resL = 0;
        int resR = 0;
        for(int i = 0 ;i < str1.length() ; i++){
            dp[i][0] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
            if(max < dp[i][0]){
                resL = i;
                max = dp[i][0];
            }
        }
        for(int i = 0; i < str2.length() ; i++){
            dp[0][i] = str1.charAt(0) == str2.charAt(i) ? 1 : 0;
            if(max < dp[0][i]){
                resR = i;
                max = dp[0][i];
            }
        }


        for(int i = 1;i < str1.length(); i++){
            for(int j = 1; j < str2.length() ; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                if(max < dp[i][j]){
                    max = dp[i][j];
                    resL = i;
                    resR = j;
                }
            }
        }


        return str2.substring(resR - max + 1, resR + 1);


    }

    public static void main(String[] args) {
        System.out.println(new NC127().LCS("1AB2345CD","12345EF"));
    }
}
