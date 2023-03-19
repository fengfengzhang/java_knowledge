package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC49
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/19 14:16
 */
public class NC49 {
    /**
     * 给出一个长度为 n 的，仅包含字符 '(' 和 ')' 的字符串，计算最长的格式正确的括号子串的长度。
     *
     * 例1: 对于字符串 "(()" 来说，最长的格式正确的子串是 "()" ，长度为 2 .
     * 例2：对于字符串 ")()())" , 来说, 最长的格式正确的子串是 "()()" ，长度为 4 .
     */
    public int longestValidParentheses (String s) {
        // write code here
        if(s == null || "".equals(s)) return 0;
        //必须以i位置结尾的有效的子括号长度
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }else{
                if(i-1 >= 0 && s.charAt(i-1) == '('){
                    dp[i] = dp[i-1] + 2;
                    dp[i] = i-2 >= 0 ? dp[i] + dp[i-2] : dp[i];
                }else if(i-1 >= 0 && s.charAt(i-1) == ')'){
                    if((i - 1 - dp[i-1] >= 0)&& s.charAt(i - 1 - dp[i-1]) == '('){
                        dp[i] = dp[i-1] + 2;
                        dp[i] = i - 2 - dp[i-1] >= 0 ? dp[i] + dp[i - 2 - dp[i-1]] : dp[i];
                    }


                }
            }

            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;

    }

}
