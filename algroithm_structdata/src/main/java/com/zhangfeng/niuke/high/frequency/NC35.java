package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC35
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/8 12:40
 */
public class NC35 {

    /**
     * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
     */
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 0 ; i <= str1.length() ; i++){
            dp[i][0] = i * dc;
        }

        for(int i = 0; i <= str2.length() ; i++){
            dp[0][i] = i * ic;
        }

        for(int i = 1 ; i <= str1.length() ; i++){
            for(int j = 1; j <= str2.length() ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{

                    dp[i][j] = Math.min(dp[i-1][j-1] + rc,Math.min(dp[i][j-1] + ic,dp[i-1][j] + dc));
                }
            }
        }

        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        NC35 nc35 = new NC35();
        System.out.println(nc35.minEditCost(
                "abc", "adc", 5, 3, 2));
    }


}
