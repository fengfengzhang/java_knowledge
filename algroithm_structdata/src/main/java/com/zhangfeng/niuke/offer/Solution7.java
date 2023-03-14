package com.zhangfeng.niuke.offer;

import java.util.Stack;

/**
 * @ClassName Solution7
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 18:37
 */
public class Solution7 {
    /**
     * JZ9
     * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
     *
     * 数据范围： n\le1000n≤1000
     * 要求：存储n个元素的空间复杂度为 O(n)O(n) ，插入与删除的时间复杂度都是 O(1)O(1)
     */

    Stack<Integer> stack1 = new Stack<Integer>();//插入
    Stack<Integer> stack2 = new Stack<Integer>();//弹出，2是1放进来的，就是正序了

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(!stack2.isEmpty()){
           return stack2.pop();
        }

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return  stack2.isEmpty() ? -1 : stack2.pop();
    }
}
