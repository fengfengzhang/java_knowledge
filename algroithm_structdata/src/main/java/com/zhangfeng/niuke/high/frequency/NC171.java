package com.zhangfeng.niuke.high.frequency;

import java.util.Map;
import java.util.Stack;

public class NC171 {
    /**
     * 给定一个数组heights，长度为n，height[i]是在第i点的高度，那么height[i]表示的直方图，能够形成的最大矩形是多少?
     * 1.每个直方图宽度都为1
     * 2.直方图都是相邻的
     * 3.如果不能形成矩形，返回0即可
     * 4.保证返回的结果不会超过231-1
     */
    public int largestRectangleArea (int[] heights) {
        // write code here

        //单调递增
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(int i = 0; i< heights.length;i++){
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int index = stack.pop();
                int left = stack.isEmpty() ? 0 : stack.peek()+1;
                res = Math.max(res,(i - left) * heights[index]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int index = stack.pop();
            int left = stack.isEmpty() ? 0 : stack.peek() + 1;
            res = Math.max(res,(heights.length - left) * heights[index]);
        }


        return res;

    }

    public static void main(String[] args) {
//        System.out.println(new NC171().largestRectangleArea(new int[]{3,4,7,8,1,2}));
        System.out.println(new NC171().largestRectangleArea(new int[]{2,1,1}));
//        System.out.println(new NC171().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}
