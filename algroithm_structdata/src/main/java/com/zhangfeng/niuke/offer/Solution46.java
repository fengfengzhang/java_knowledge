package com.zhangfeng.niuke.offer;

import java.util.HashMap;

/**
 * @ClassName Solution46
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 9:40
 */
public class Solution46 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * 数据范围:
     * \ \text{s.length}\le 40000 s.length≤40000
     */
    public int lengthOfLongestSubstring (String s) {
        // write code here
        int left = 0;
        int maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1) ;
            }
            map.put(s.charAt(i),i);
            maxLength = Math.max(i - left + 1,maxLength);

        }
        return maxLength;



    }

    public static void main(String[] args) {
        System.out.println(new Solution46().lengthOfLongestSubstring("pwwkew"));
    }
}
