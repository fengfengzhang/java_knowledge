package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;
import java.util.Stack;

public class NC237 {
    /**
     * 描述
     * 给定一个仅包含 0 和 1 ，大小为 n*m 的二维二进制矩阵，找出仅包含 1 的最大矩形并返回面积。
     *
     * 数据范围：
     * 1
     * ≤
     * n
     * ,
     * m
     * ≤
     * 200
     *
     * 1≤n,m≤200  保证输入的矩形中仅含有 0 和 1
     */
    public int maximalRectangle (int[][] matrix) {
        // write code here
        int res = 0;
        int[] temp = new int[matrix[0].length];
        for(int i = 0; i < matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += matrix[i][j];
                }
            }

            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < temp.length ; j++){
                int count = 0;

                if(stack.isEmpty()){
                    stack.push(temp[j]);
                    continue;
                }

                //栈单掉递增，如果出现小于了，那么栈内的元素，进行结算。矩形的长不断累加，宽就是栈元素的值。计算完成，后面的要插入的元素用自己站位表示，我能向两边扩到多远
                //遇到0也没关系，0*长等于0不影响结果。遇到0前面所有的都会进行结算，最后剩下的单调递增的在结算一次
                if(!stack.isEmpty() && stack.peek() <= temp[j]){
                    stack.push(temp[j]);
                }else{
                     while (!stack.isEmpty() && stack.peek() > temp[j]){
                         count ++;
                         res = Math.max(res,stack.pop() * count);
                     }
                     for(int k = 0 ; k <= count ; k++){
                         stack.push(temp[j]);
                     }
                }

            }


           for(int k = 0;k < temp.length ; k++){
               res = Math.max(res,stack.pop() * (k + 1));
           }


        }

        return  res;
    }


    public static void main(String[] args) {
       /* System.out.println(new NC237().maximalRectangle(new int[][]{
                {1,0,1,0,0},{1,1,1,1,0},{1,1,1,1,1},{1,0,0,1,0}
        }));*/
        System.out.println(new NC237().maximalRectangle(new int[][]{
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        }));
    }

}
