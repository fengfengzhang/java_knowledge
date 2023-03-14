package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName Solution57
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 12:44
 */
public class Solution57 {

    /**
     * JZ59
     * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     *
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     *
     * 窗口大于数组长度或窗口长度为0的时候，返回空。
     *
     * 数据范围： 1 \le n \le 100001≤n≤10000，0 \le size \le 100000≤size≤10000，数组中每个元素的值满足 |val| \le 10000∣val∣≤10000
     * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0 || num.length < size || size == 0){
            return list;
        }
        int left = 0;
        int right = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        while (right < num.length){
            while (maxQueue.size() != 0 && maxQueue.getLast() < num[right]){
                maxQueue.removeLast();
            }

            if(maxQueue.size() == 0 || maxQueue.getLast() >= num[right]){
                maxQueue.add(num[right]);
            }

            if(right - left + 1 == size){
                list.add(maxQueue.getFirst());
                if(maxQueue.getFirst() == num[left]){
                    maxQueue.removeFirst();
                }
                left ++;
            }
            right ++;


        }

        return list;

    }

    public static void main(String[] args) {
        System.out.println(new Solution57().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }



}
