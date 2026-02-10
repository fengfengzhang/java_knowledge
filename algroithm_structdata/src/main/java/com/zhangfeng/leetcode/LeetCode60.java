package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode60
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/10 15:00
 */

import java.util.*;
public class LeetCode60 {
    /**
     * 出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     *
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     *
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * @param n
     * @param k
     * @return
     */

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i= 1; i< n ; i++){
            factorial[i] = factorial[i-1] * i;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i =1 ; i <=n ; i++){
            numbers.add(i);
        }

        k --;

        StringBuilder result = new StringBuilder();
        for(int i = n -1 ; i>= 0 ; i--){
            int index = k /factorial[i];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[i];
        }

       return result.toString();
    }

    /*private int count = 0;
    private String result = null;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        count = 0;
        result = null;
        backtrack(0, nums, k);
        return result;
    }

    private void backtrack(int start, int[] nums, int k) {
        // 剪枝：如果已经找到结果，直接返回
        if (result != null) {
            return;
        }

        // 找到一个完整的排列
        if (start == nums.length) {
            count++;
            if (count == k) {
                StringBuilder sb = new StringBuilder();
                for (int num : nums) {
                    sb.append(num);
                }
                result = sb.toString();
            }
            return;
        }

        // 🔑 关键：保证字典序
        // 1. 收集从start开始的所有位置索引
        List<Integer> indices = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            indices.add(i);
        }

        // 2. 按照 nums[i] 的值排序索引，确保按字典序选择
        indices.sort(Comparator.comparingInt(i -> nums[i]));

        // 3. 按照排序后的顺序选择数字
        for (int idx : indices) {
            swap(nums, start, idx);
            backtrack(start + 1, nums, k);
            swap(nums, start, idx); // 回溯

            // 找到结果后立即返回
            if (result != null) {
                return;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/


    public static void main(String[] args) {
        System.out.println(new LeetCode60().getPermutation(3, 3));
    }

}