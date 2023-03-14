package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @ClassName Solution38
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 12:38
 */
public class Solution38 {
    /**
     * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
     * 数据范围：0\le k,n \le 100000≤k,n≤10000，数组中每个数的大小0 \le val \le 10000≤val≤1000
     * 要求：空间复杂度 O(n)O(n) ，时间复杂度 O(nlogk)O(nlogk)
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < input.length ; i++){
           addNumber(queue,input[i],k);
        }

        ArrayList<Integer> list = new ArrayList<>(queue);
        Collections.sort(list);
        return list;
    }


    public void addNumber(PriorityQueue<Integer> queue , int num,  int k){
        if(queue.size() < k){
            queue.add(num);
            return;
        }

        if(!queue.isEmpty() && queue.peek() > num){
            queue.poll();
            queue.add(num);
        }
    }
}
