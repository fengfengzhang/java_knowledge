package com.zhangfeng.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName LeetCode139
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/18 22:06
 */
public class LeetCode139 {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = set.contains(s.substring(0,1));

        for(int i = 1; i < s.length() ; i++){
            for(int j = i; j >= 0 ; j--){
                dp[i] = set.contains(s.substring(j,i+1)) && (j - 1 < 0 || dp[j - 1]);
                if(dp[i]) break;
            }
        }

        return dp[s.length()-1];
    }


    public static void main(String[] args) {
        LeetCode139 leetCode139 = new LeetCode139();
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(leetCode139.wordBreak("leetcode", list));
    }
}
