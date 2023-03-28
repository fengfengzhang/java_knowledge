package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName BM45
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/28 21:05
 */
public class BM45 {

    /**
     * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || num.length < size || size == 0) return res;
        int left = 0;
        int right = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        while (right < num.length){
            while (!queue.isEmpty() && queue.getLast() < num[right]){
                  queue.removeLast();
            }
            queue.addLast(num[right]);
            if(right - left + 1 >= size){
                res.add(queue.getFirst());
                if(queue.getFirst() == num[left]){
                    queue.removeFirst();
                }
                left ++;
            }

            right ++;
        }
        return res;

    }


    public static void main(String[] args) {
        BM45 bm45 = new BM45();
        System.out.println(bm45.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }



}
