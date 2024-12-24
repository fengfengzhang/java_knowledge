package com.zhangfeng.juejin;

public class Solution25 {
    /**
     * 小R正在研究DNA序列，他需要一个函数来计算将一个受损DNA序列（dna1）转换成一个未受损序列（dna2）所需的最少编辑步骤。编辑步骤包括：增加一个碱基、删除一个碱基或替换一个碱基。
     */
    public static int solution(String dna1, String dna2) {

        int[][] dp = new int[dna1.length() + 1][dna2.length() + 1];

        for(int i = 0; i < dp.length ;i++){
            dp[i][0] = i;
        }

        for (int i = 0 ;i < dp[0].length ; i++){
            dp[0][i] = i;
        }


        for(int i = 1; i < dp.length ;i ++){
            for(int j = 1 ; j <dp[i].length ; j++){

                if(dna1.charAt(i-1) == dna2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] ,dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[dna1.length()][dna2.length()];

    }

    public static void main(String[] args) {
        System.out.println(Solution25.solution("AGCCGAGC", "GCTAGCT"));
    }

}
