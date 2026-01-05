package com.zhangfeng.leetcode;

import java.util.*;

/**
 * @ClassName LeetCode150
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/1/5 18:03
 */
public class LeetCode150 {
    //逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("*", "/", "+", "-"));

        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;

                }

            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }

        }


        return stack.pop();

    }

}