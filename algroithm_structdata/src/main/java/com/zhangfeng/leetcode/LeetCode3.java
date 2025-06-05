package com.zhangfeng.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LeetCode3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        LinkedList<Character> list = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                max = Math.max(max, list.size());
                // 移除重复字符及其之前的所有字符
                while (!list.isEmpty()) {
                    Character removed = list.removeFirst();
                    set.remove(removed);
                    if (removed == c) { // 注意：这里使用==比较，因为Character是对象，但char自动装箱为Character，且对于ASCII字符，会使用缓存，但安全起见用equals
                        break;
                    }
                }
            }
            list.addLast(c);
            set.add(c);
        }
        max = Math.max(max, list.size());
        return max;
    }

    /*public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] index = new int[128]; // 存储字符最近出现的位置+1（这样可以直接作为left的新位置）
        Arrays.fill(index, 0); // 初始化为0
        int left = 0; // 窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果当前字符已经出现过，并且出现的位置在窗口内（即大于等于left），则移动left
            if (index[c] > left) {
                left = index[c];
            }
            // 更新当前字符的位置为right+1（这样当再次遇到该字符时，left可以直接跳到这个位置）
            index[c] = right + 1;
            // 计算当前窗口长度
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
*/
    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abcabcbb"));
    }
}
