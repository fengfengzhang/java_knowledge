package com.zhangfeng.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class LeetCode347 {
    /*
    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案
     */

    class Item{
        int num;
        int times;
        public Item(int num,int times){
            this.num = num;
            this.times = times;
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Item> map = new HashMap<>();
        PriorityQueue<Item> queue = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2.times, o1.times);
        });

        for (int num : nums) {
            if (map.containsKey(num)) {
                Item item = map.get(num);
                item.times++;
            } else {
                map.put(num, new Item(num, 1));
            }
        }

         for(Integer key : map.keySet()){
             queue.add(map.get(key));
         }

         int[] res = new int[k];
         for(int i = 0; i < k ;i ++){
             res[i] = Objects.requireNonNull(queue.poll()).num;
         }

         return res;

    }
}
