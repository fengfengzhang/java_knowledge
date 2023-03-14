package com.zhangfeng.niuke.offer;

import java.util.Arrays;

/**
 * @ClassName Solution83
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 11:25
 */
public class Solution83 {

    /**
     * JZ85
     * 描述
     * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
     * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     * 2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
     * 3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
     * 4.返回的数组不计入空间复杂度计算
     */

    public int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        if(array.length == 1){
            return array;
        }

        int max = Integer.MIN_VALUE;
        int maxLength = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        int leftRes = 0;

        for(int i = 0; i < array.length ; i++){
            temp += array[i];
            right ++;
            if(max < temp || max == temp && (right - left)> maxLength){
                max = temp;
                leftRes = left;
                maxLength = right - left;
            }

            if(temp < 0){
                max = Math.max(max,array[i]);
                temp = 0;
                left = right;
            }



        }

        int[] res = new int[maxLength];
        for(int i = 0; i <res.length ; i++){
            res[i] = array[i + leftRes];
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution83().FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5})));
    }

}



