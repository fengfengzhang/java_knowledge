package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution17
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 21:31
 */
public class Solution17 {
    /**
     * JZ19
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 1.模式中的字符'.'表示任意一个字符
     * 2.模式中的字符'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *数据范围:
     * 1.str 只包含从 a-z 的小写字母。
     * 2.pattern 只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
     * 3. 0 \le str.length \le 26 \0≤str.length≤26
     * 4. 0 \le pattern.length \le 26 \0≤pattern.length≤26
     */
    public boolean match (String str, String pattern) {
        // write code here
        boolean[][] dp = new boolean[pattern.length()][str.length()];

        dp[0][0] = pattern.charAt(0) == str.charAt(0) || pattern.charAt(0) == '.';

        for(int i = 1; i < pattern.length() ; i++){
            if(pattern.charAt(i) == '*'){
                dp[i][0] = pattern.charAt(i-1) == str.charAt(0) || pattern.charAt(0) == '.';
                dp[i][0] = i >= 2 ? dp[i][0] || dp[i-2][0] : dp[i][0];
            }else{
                //必须和一个字符匹配，看看前面是否等价成了空串
                int index = i - 1;
                while(index >= 0 && pattern.charAt(index) == '*'){
                    index = index -2;
                }

                dp[i][0] = index < 0 &&(pattern.charAt(i) == str.charAt(0) || pattern.charAt(i) == '.');
            }

        }

        for(int i = 1; i < pattern.length() ; i++){
            for(int j = 1; j < str.length() ; j++){
                if(pattern.charAt(i) == '.' || pattern.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                if(pattern.charAt(i) == '*'){
                    dp[i][j] = (pattern.charAt(i-1) == str.charAt(j) || pattern.charAt(i-1) == '.') && (dp[i-1][j-1] || dp[i][j-1]);
                    dp[i][j] = i >=2 ? dp[i][j] || dp[i-2][j] : dp[i][j];
                }

            }
        }

        return dp[pattern.length() - 1][str.length() -1];

    }

    public static void main(String[] args) {
        System.out.println(new Solution17().match("aaa",".*"));
    }

}
