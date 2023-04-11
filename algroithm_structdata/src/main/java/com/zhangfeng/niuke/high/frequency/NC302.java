package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;

/**
 * @ClassName NC302
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 19:58
 */
public class NC302 {
    /**
     * 给定一个长度为
     * �
     * n 的环形整数数组
     * �
     * �
     * �
     * �
     * nums ，返回
     * �
     * �
     * �
     * �
     * nums的非空 连续子数组 的最大可能和 。
     * 环形数组 意味着数组的末端将会与开头相连呈环状。例如，
     * �
     * �
     * �
     * �
     * [
     * 0
     * ]
     * nums[0] 的前一个数是
     * �
     * �
     * �
     * �
     * [
     * �
     * −
     * 1
     * ]
     * nums[n−1]。
     * 数据范围：
     */

    public int maxSubarraySumCircular (ArrayList<Integer> nums) {
        // write code here
        if(nums == null || nums.isEmpty()) return 0;
        int cur = nums.get(0);
        int max = cur;
        int sum = cur;
        for(int i = 1 ;i < nums.size() ; i++){
            if(cur <= 0){
                cur = 0;
            }
            cur += nums.get(i);
            sum += nums.get(i);
            max = Math.max(max,cur);

        }

        cur = nums.get(0);
        int min = cur;
        for(int i = 1; i < nums.size() ; i++){
            if(cur >= 0){
                cur = 0;
            }
            cur += nums.get(i);
            min = Math.min(min,cur);

        }

        if(max < 0) return max;

        return Math.max(max,sum - min);
    }

    public static void main(String[] args) {
        NC302 nc302 = new NC302();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-2);
        list.add(3);
        list.add(-2);
        System.out.println(nc302.maxSubarraySumCircular(list));

    }
}
