package com.zhangfeng.niuke.high.frequency;

import java.util.HashMap;

public class JZ48 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */
    public int lengthOfLongestSubstring (String s) {
        // write code here
        HashMap<Character,Integer> map = new HashMap<>();
        int length = 0 ;

        int left = 0;
        for(int i = 0; i < s.length(); i++){
           if(map.containsKey(s.charAt(i))){
               left = Math.max(left,map.get(s.charAt(i)) + 1);
           }
           length = Math.max(length,i - left + 1);
           map.put(s.charAt(i),i);
        }

       return length;

    }

    public static void main(String[] args) {
        JZ48 jz48 = new JZ48();
//        System.out.println(jz48.lengthOfLongestSubstring("N$po-O66.n=h!!#oJM#MNh:kIwxSEjFP7F)(@ROpH5x|t*XC+[`jkWor@F!Cmu8{|rft,fx;QM1p4W+U|9`gk_}(0*=cc93P"));
        System.out.println(jz48.lengthOfLongestSubstring(" "));
    }
}
