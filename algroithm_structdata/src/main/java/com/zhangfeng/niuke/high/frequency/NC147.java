package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName NC147
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 12:02
 */
public class NC147 {
    /**
     * 有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 starti ,第 i 个活动的结束时间是 endi ,举办某个活动就需要为该活动准备一个活动主持人。
     *
     * 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i 个活动，那么该主持人在 (starti,endi) 这个时间段不能参与其他任何活动。求为了成功举办这 n 个活动，最少需要多少名主持人。
     *
     * 数据范围: 1 \le n \le 10^51≤n≤10
     * 5
     *   ， -2^{32} \le start_i\le end_i \le 2^{31}-1−2
     * 32
     *  ≤start
     * i
     * ​
     *  ≤end
     * i
     * ​
     *  ≤2
     * 31
     *  −1
     *
     * 复杂度要求：时间复杂度 O(n \log n)O(nlogn) ，空间复杂度 O(n)O(n)
     */

    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // write code here
        Arrays.sort(startEnd,(o1,o2)->{
            if(o1[0] > o2[0]){
                return 1;
            }else if(o1[0] == o2[0]){
                return o1[1] > o2[1] ? 1 : -1;
            }else{
                return -1;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for (int[] ints : startEnd) {
            if (queue.isEmpty()) {
                queue.add(ints[1]);
            } else {
                if (queue.peek() <= ints[0]) {
                    queue.poll();
                }
                queue.add(ints[1]);
            }
        }


        return queue.size();
    }
}
