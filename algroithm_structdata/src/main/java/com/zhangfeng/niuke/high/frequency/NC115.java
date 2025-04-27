package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;
import java.util.Stack;

public class NC115 {
    /**
     * 描述
     * 给你一个 1 到 n 的排列和一个栈，并按照排列顺序入栈
     *
     * 你要在不打乱入栈顺序的情况下，仅利用入栈和出栈两种操作，输出字典序最大的出栈序列
     *
     * 排列：指 1 到 n 每个数字出现且仅出现一次
     *
     * 数据范围：
     * 1
     * ≤
     * n
     * ≤
     * 5
     * ×
     * 1
     * 0
     * 4
     * 1≤n≤5×10
     * 4
     *  ，排列中的值都满足
     * 1
     * ≤
     * v
     * a
     * l
     * ≤
     * n
     * 1≤val≤n
     *
     * 进阶：空间复杂度
     * O
     * (
     * n
     * )
     * O(n) ，时间复杂度
     * O
     * (
     * n
     * )
     * O(n)
     * [2,1,5,3,4]
     * [5,4,3,1,2]
     */

    /*
     如果后面存在比当前数值大的元素，则当前数值入栈，否则的话，当前值进入结果，但是要看栈中的数值是不是比其他的都大，不是才看后面的
     */
    public int[] solve (int[] a) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[a.length];
        int[] res = new  int[a.length];
        int index = 0;

        temp[a.length - 1] = a[a.length - 1];
        for(int i = a.length - 2; i >=0  ; i--){
            temp[i] = Math.max(a[i],temp[i+1]);
        }

        for(int i = 0 ;i < a.length ; i++){
            while (!stack.isEmpty() && stack.peek() >= temp[i]){
                res[index ++] = stack.pop();
            }
            stack.push(a[i]);
        }

        while (!stack.isEmpty()){
            res[index ++] = stack.pop();
        }

      return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NC115().solve(new int[]{5,8,9,6,7,1,3,2,4})));
    }

}


