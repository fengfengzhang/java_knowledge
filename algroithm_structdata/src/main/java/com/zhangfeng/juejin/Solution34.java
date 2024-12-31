package com.zhangfeng.juejin;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution34 {

    /**
     * 小M想要通过查看往届游戏比赛的排名来确定自己比赛的目标分数。他希望找到往届比赛中排名第三的分数，作为自己的目标。具体规则如下：
     *
     * 如果分数中有三个或以上不同的分数，返回其中第三大的分数。
     * 如果不同的分数只有两个或更少，那么小M将选择最大的分数作为他的目标。
     * 请你帮小M根据给定的分数数组计算目标分数。
     * @param n
     * @param nums
     * @return
     */
    public static int solution(int n, int[] nums) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
           return o2.compareTo(o1);
        });

        for (int j : nums) {
            queue.add(j);
        }

        int res = 0;
        if(!queue.isEmpty()){
            res = queue.peek();
        }

        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()){
            Integer num = queue.poll();
            set.add(num);
            if(set.size() == 3){
                res = num;
                break;
            }

        }


        return res;
    }
}
