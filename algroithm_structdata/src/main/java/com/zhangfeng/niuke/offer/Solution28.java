package com.zhangfeng.niuke.offer;

import java.util.Stack;

/**
 * @ClassName Solution28
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 11:48
 */
public class Solution28 {

    /**
     * JZ30
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
     *
     * 此栈包含的方法有：
     * push(value):将value压入栈中
     * pop():弹出栈顶元素
     * top():获取栈顶元素
     * min():获取栈中最小元素
     *
     * 数据范围：操作数量满足 0 \le n \le 300 \0≤n≤300  ，输入的元素满足 |val| \le 10000 \∣val∣≤10000
     * 进阶：栈的各个操作的时间复杂度是 O(1)\O(1)  ，空间复杂度是 O(n)\O(n)
     */

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || minStack.peek() >= node){
            minStack.push(node);
        }

    }

    public void pop() {
        int pop = stack.pop();
        if(minStack.peek()== pop){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        //["PSH2","PSH3","PSH6","PSH2","PSH4","PSH5","POP","POP","POP","MIN"]

        Solution28 solution28 = new Solution28();
        solution28.push(2);
        solution28.push(3);
        solution28.push(6);
        solution28.push(2);
        solution28.push(4);
        solution28.push(5);
        solution28.pop();
        solution28.pop();
        solution28.pop();
        System.out.println(solution28.min());
    }

}
