package com.zhangfeng.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     *
     * 子数组是数组中元素的连续非空序列。
     */

    public int subarraySum(int[] nums, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0,list);

        int cur = 0;
        int res = 0;
        for(int i = 0; i < nums.length ; i++){
            cur += nums[i];
            if(map.containsKey(cur - k)){
                res += map.get(cur - k).size();
            }
            if(map.containsKey(cur)){
                map.get(cur).add(i);
            }else{
                list = new ArrayList<>();
                list.add(i);
                map.put(cur,list);
            }

        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode560().subarraySum(new int[]{1, 2, 3}, 3));
    }
}
