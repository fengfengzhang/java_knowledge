package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution8
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 18:47
 */
public class Solution8 {
    /**
     * JZ10
     * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
     * 斐波那契数列是一个满足 fib(x)=\left\{ \begin{array}{rcl} 1 & {x=1,2}\\ fib(x-1)+fib(x-2) &{x>2}\\ \end{array} \right.fib(x)={
     * 1
     * fib(x−1)+fib(x−2)
     * ​
     *
     * x=1,2
     * x>2
     * ​
     *   的数列
     * 数据范围：1\leq n\leq 401≤n≤40
     * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n) ，本题也有时间复杂度 O(logn)O(logn) 的解法
     */
    public int Fibonacci(int n) {

        if(n == 1 || n == 2){
            return 1;
        }
        int num1 = 1;
        int num2 = 1;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }

        return  res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution8().Fibonacci(4));
    }

}
