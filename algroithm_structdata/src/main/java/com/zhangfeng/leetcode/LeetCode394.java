package com.zhangfeng.leetcode;

import java.util.Stack;

/**
 * @ClassName LeetCode394
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/9/22 18:20
 */
public class LeetCode394 {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     * 测试用例保证输出的长度不会超过 105。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
      */

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length() ; i++){

            if(s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            }else{
                StringBuilder sb = new StringBuilder();

                while (!stack.isEmpty()&& stack.peek() != '['){
                    Character pop = stack.pop();
                    sb.insert(0,pop);
                }

                stack.pop();
                String subString = sb.toString();

                StringBuilder intPos = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    intPos.insert(0,stack.pop());
                }


                for(int j = 0; j < Integer.parseInt(intPos.toString()); j ++){
                    for(int k =0;k < subString.length() ; k++){
                        stack.push(subString.charAt(k));
                    }

                }


            }

        }

        StringBuilder resBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            resBuilder.insert(0,stack.pop());
        }

        return resBuilder.toString();

    }


    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
        System.out.println(leetCode394.decodeString("3[a2[c]]"));


    }
}