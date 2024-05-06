package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NC91 {
    /**
     * 给定数组 arr ，设长度为 n ，输出 arr 的最长上升子序列。（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
     *
     * 数据范围：
     * 0
     * ≤
     * 𝑛
     * ≤
     * 200000
     * ,
     * 0
     * ≤
     * 𝑎
     * 𝑟
     * 𝑟
     * 𝑖
     * ≤
     * 1000000000
     * 0≤n≤200000,0≤arr
     * i
     * ​
     *  ≤1000000000
     * 要求：空间复杂度
     * 𝑂
     * (
     * 𝑛
     * )
     * O(n)，时间复杂度
     * 𝑂
     * (
     * 𝑛
     * 𝑙
     * 𝑜
     * 𝑔
     * 𝑛
     * )
     * O(nlogn)
     */
    public int[] LIS (int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] dp = new int[arr.length]; //必须以当前位置结尾的最长长度
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length ; i++){
            if(list.isEmpty() || list.get(list.size() - 1) < arr[i]){
                list.add(arr[i]);
                dp[i] = list.size();
            }else{
                int left = 0;
                int right = list.size() -1;
                while (left <= right){
                    int mid = (left + right)/2;

                    if(list.get(mid) < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }

                list.set(left,arr[i]);
                dp[i] = left + 1;
            }
        }


        int n = list.size();
        int[] res = new int[n];


        for (int i = dp.length - 1; i >= 0 ; i--) {
            if(dp[i] == n){
                res[--n] = arr[i];
            }
        }
        return res;


    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new NC91().LIS(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7})));
        System.out.println(Arrays.toString(new NC91().LIS(new int[]{1,3,8,6,5,2,5})));
    }
}
