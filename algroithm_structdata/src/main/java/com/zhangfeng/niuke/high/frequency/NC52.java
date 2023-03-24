package com.zhangfeng.niuke.high.frequency;

import java.util.Stack;

/**
 * @ClassName NC52
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/24 20:21
 */
public class NC52 {

    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     */

    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else {
                return false;
            }
        }

        return stack.isEmpty();

    }

}
