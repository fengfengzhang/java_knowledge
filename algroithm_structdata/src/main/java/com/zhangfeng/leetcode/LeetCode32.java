package com.zhangfeng.leetcode;

public class LeetCode32 {

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     */

    public int longestValidParentheses(String s) {
        if(s.isEmpty()){
            return 0;
        }

        int max = 0;
        //必须以当前位置结尾的有效括号长度
        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }else {
                if(i -1 >= 0 && s.charAt(i -1) == '('){
                    dp[i] = dp[i-1] + 2;
                    dp[i] = i-2 >= 0 ? dp[i] + dp[i-2] : dp[i];
                }
                if( i -1 >= 0 && s.charAt(i-1) == ')'){
                    if((i - 1 - dp[i-1] >= 0) && s.charAt(i-1-dp[i-1]) == '(' ){
                        dp[i] = dp[i-1] + 2;
                        dp[i] = i - 2 - dp[i-1] >= 0 ? dp[i] + dp[i - 2 - dp[i-1]] : dp[i];

                    }
                }


            }

            max = Math.max(dp[i],max);

        }

        return max;


    }


    public static void main(String[] args) {
        System.out.println(new LeetCode32().longestValidParentheses("(()())"));
    }

}
