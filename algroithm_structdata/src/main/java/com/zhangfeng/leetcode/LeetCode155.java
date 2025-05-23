package com.zhangfeng.leetcode;

import java.util.Stack;

public class LeetCode155 {
    /**
     * 最小栈
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * 实现 MinStack 类:
     *
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     */

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);

           if (!minStack.isEmpty() && minStack.peek() < val){
                return;
            }
            minStack.push(val);
        }

        public void pop() {
            if(stack.isEmpty()){
                return;
            }
            int item = stack.pop();

            if(!minStack.isEmpty() && minStack.peek() == item){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
           return minStack.peek();
        }
    }
}
