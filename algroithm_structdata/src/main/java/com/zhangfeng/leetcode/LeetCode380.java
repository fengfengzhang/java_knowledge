package com.zhangfeng.leetcode;

import java.util.*;

public class LeetCode380 {
    /**
     * 实现RandomizedSet 类：
     *
     * RandomizedSet() 初始化 RandomizedSet 对象
     * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
     * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
     * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
     * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
     */

    class RandomizedSet {

        private Map<Integer,Integer> map;

        private List<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }

            map.put(val,list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
           if(!map.containsKey(val)){
               return false;
           }

            int lastData = list.get(list.size() - 1);

            int index = map.get(val);
            map.put(lastData,index);

            map.remove(val);

            list.set(index,lastData);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
           int index = (int)(Math.random() * list.size());
           return list.get(index);
        }
    }
}
