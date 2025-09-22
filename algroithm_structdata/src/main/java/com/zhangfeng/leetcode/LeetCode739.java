package com.zhangfeng.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName LeetCode739
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/9/22 18:00
 */
public class LeetCode739 {

    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     *
     *
     * 示例 1:
     *
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     *
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     */

    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length ; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else  if (temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            }else{
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int pop = stack.pop();
                    answer[pop] = i - pop;
                }
                stack.push(i);
            }

        }

        while (!stack.isEmpty()){
            answer[stack.pop()] = 0;
        }

        return answer;
    }


    public static void main(String[] args) {
        LeetCode739 leetCode739 = new LeetCode739();
        System.out.println(Arrays.toString(leetCode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}