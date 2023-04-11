package com.zhangfeng.niuke.high.frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName NC170
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 19:20
 */
public class NC170 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * 数据范围:
     */
    public int lengthOfLongestSubstring (String s) {
        // write code here

        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
               left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }


        return max;
    }

    public static void main(String[] args) {
        NC170 nc170 = new NC170();
        System.out.println(nc170.lengthOfLongestSubstring(" "));
    }

}
