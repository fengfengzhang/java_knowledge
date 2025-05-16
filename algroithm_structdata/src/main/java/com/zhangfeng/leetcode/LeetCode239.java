package com.zhangfeng.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode239 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k +1];

        int resIndex = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length ){
            while (!queue.isEmpty() && queue.getLast() < nums[right]){
                queue.removeLast();
            }
            queue.addLast(nums[right]);
            if(right - left + 1 >= k){
                res[resIndex ++] = queue.getFirst();
                if(queue.getFirst() == nums[left]){
                    queue.removeFirst();
                }
                left ++;

            }
            right++;

        }

        return res;

    }

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();

        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
