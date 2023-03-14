package com.zhangfeng.niuke.offer;

import java.util.Stack;

/**
 * @ClassName Solution29
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 17:35
 */
public class Solution29 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * 1. 0<=pushV.length == popV.length <=1000
     * 2. -1000<=pushV[i]<=1000
     * 3. pushV 的所有数字均不相同
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        while (pushIndex < pushA.length && popIndex < popA.length){

            while (!stack.isEmpty() && popIndex < popA.length && stack.peek() == popA[popIndex]){
                popIndex ++;
                stack.pop();
            }


           stack.push(pushA[pushIndex ++]);
        }

        while (!stack.isEmpty()){
            if(stack.peek() == popA[popIndex]){
                popIndex ++;
                stack.pop();
            }else{
                break;
            }

            if(popIndex >= popA.length)break;
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new Solution29().IsPopOrder(new int[]{1}, new int[]{2}));
    }

}
