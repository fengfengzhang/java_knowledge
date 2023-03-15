package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName NC306
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 10:40
 */
public class NC306 {
    /**
     * 给定一个长度为 n 的整数数组，请你找出其中最长的乘积为正数的子数组长度。
     * 子数组的定义是原数组中一定长度的连续数字组成的数组。
     *
     * 数据范围： 1 \le n \le 10^5 \1≤n≤10
     * 5
     *    , 数组中的元素满足 |val| \le 10^9 \∣val∣≤10
     * 9
     */
    public int findLongestSubArray (ArrayList<Integer> nums) {
        // write code here
        int length = 0;
        int left = 0;

        List<Integer> list = new ArrayList<>();
        int i;
        for(i = 0; i < nums.size() ; i++){
            if(nums.get(i) < 0){
                list.add(i);
            }

            if(nums.get(i) == 0){
                length =Math.max(length,process(left, i, list));
                left = i + 1;
                list = new ArrayList<>();
            }
        }

        if(nums.get(nums.size() - 1) != 0){
            length = Math.max(length,process(left, i, list));
        }

        return length;
    }

    public int process(int left , int i , List<Integer> list){

        if((list.size() & 1) == 0){
            return  i - left;
        }else{

            int length = 0;
            //---------  -1 ---- -3 --- -2 -------i(0)
            int rightBound = list.get(list.size() - 1) - 1;
            if(rightBound >= left){
                length = rightBound - left + 1;
            }
            int leftBound = list.get(0) + 1;
            if(i -1 >= leftBound){
                length = Math.max(length,i - leftBound);
            }
            return length;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{8,11,2,-10,18,10,11,17,24,-4};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++){
            list.add(arr[i]);
        }

        System.out.println(new NC306().findLongestSubArray(list));
    }

}
