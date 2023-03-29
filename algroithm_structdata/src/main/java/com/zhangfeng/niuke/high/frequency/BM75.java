package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM75
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/29 14:32
 */
public class BM75 {
    /**
     * 给定两个字符串 str1 和 str2 ，请你算出将 str1 转为 str2 的最少操作数。
     * 你可以对字符串进行3种操作：
     * 1.插入一个字符
     * 2.删除一个字符
     * 3.修改一个字符。
     */
    public int editDistance (String str1, String str2) {
        // write code here
        if(str1 == null || str2 == null) return 0;
        int[][] dp = new int[str1.length() +1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i < dp[0].length ; i++){
            dp[0][i] = i;
        }

        for(int i =1 ; i <= str1.length() ; i++){
            for(int j = 1; j <= str2.length() ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }

            }
        }

        return dp[str1.length()][str2.length()];


    }

    public static void main(String[] args) {
        BM75 bm75 = new BM75();
        System.out.println(bm75.editDistance("nowcoder","new"));
    }

}
