package com.zhangfeng.niuke.high.frequency;

import java.util.HashMap;

/**
 * @ClassName N125
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 11:35
 */
public class N125 {
    /**
     * 给定一个无序数组 arr , 其中元素可正、可负、可0。给定一个整数 k ，求 arr 所有连续子数组中累加和为k的最长连续子数组长度。保证至少存在一个合法的连续子数组。
     * [1,2,3]的连续子数组有[1,2]，[2,3]，[1,2,3] ，但是[1,3]不是
     *
     * 数据范围： 1 \le n \le 10^51≤n≤10
     * 5
     *  ，|val| \le 100∣val∣≤100，|k| \le 10^9∣k∣≤10
     * 9
     *
     * 要求：空间复杂度 O(n)O(n) ， 时间复杂度 O(n)O(n)
     */

    public int maxlenEqualK (int[] arr, int k) {
        // write code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int cur = 0;
        int length = 0;
        for(int i = 0; i < arr.length ; i++){
            cur += arr[i];
            if(map.containsKey(cur - k)){
              length = Math.max(length, i - map.get(cur - k));
            }

            if(!map.containsKey(cur)){
                map.put(cur,i);
            }
        }
        return length;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,1,1,1};
        System.out.println(new N125().maxlenEqualK(arr, 0));
    }
}
