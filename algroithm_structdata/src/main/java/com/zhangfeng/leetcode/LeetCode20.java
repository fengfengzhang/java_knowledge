package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode20
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/11 14:40
 */

import java.util.*;
public class LeetCode20 {
    /**
     * 有效括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(int i = 0; i < s.length() ; i++){
            if(!stack.isEmpty() && map.containsKey(s.charAt(i))&& stack.peek() == map.get(s.charAt(i))){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }

        }

        return stack.isEmpty();

    }
}