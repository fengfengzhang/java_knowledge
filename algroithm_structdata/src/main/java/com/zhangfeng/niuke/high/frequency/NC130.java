package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;

/**
 * @ClassName NC130
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 10:23
 */
public class NC130 {

    /**
     * 一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
     *
     * 1. 每个孩子不管得分多少，起码分到一个糖果。
     * 2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
     *
     * 给定一个数组 arrarr 代表得分数组，请返回最少需要多少糖果。
     *
     * 要求: 时间复杂度为 O(n)O(n) 空间复杂度为 O(n)O(n)
     *
     * 数据范围： 1 \le n \le 1000001≤n≤100000 ，1 \le a_i \le 10001≤a
     * i
     * ​
     *  ≤1000
     */
    public int candy (int[] arr) {
        // write code here
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);

        for(int i = 1; i < arr.length ; i++){
            if(arr[i -1] < arr[i]){
                dp[i] = dp[i-1] + 1;
            }
        }
        for(int i = arr.length - 2 ; i >= 0; i --){
            if(arr[i] > arr[i + 1] && dp[i] <= dp[i+1]){
                dp[i] = dp[i+1] + 1;

        }
        }

        return   Arrays.stream(dp).boxed().mapToInt(Integer::intValue).sum();


    }

    public static void main(String[] args) {
        System.out.println(new NC130().candy(new int[]{1,1,2}));
    }
}
