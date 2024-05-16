package com.zhangfeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode53 {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

    public class Node {
        int start;
        int end;

        public Node(int start , int end){
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
       if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0){
           return new int[][]{};
       }

       PriorityQueue<Node> queue = new PriorityQueue<>(
               (i,j) ->{
                   if(i.start < j.start){
                       return -1;
                   }else if(i.start > j.start){
                       return 1;
                   }else{
                       return i.end < j.end ? -1 : 1;
                   }
               }
       );

       ArrayList<Node> list = new ArrayList<>();

        for (int[] interval : intervals) {
            queue.add(new Node(interval[0], interval[1]));
        }

       while (!queue.isEmpty()){
           Node node = queue.poll();
           if(list.isEmpty()){
               list.add(node);
           }else{
               Node preNode = list.get(list.size() - 1);
               if(preNode.start <= node.start && preNode.end >= node.start){
                   preNode.end = Math.max(node.end,preNode.end);
               }else{
                   list.add(node);
               }
           }
       }

       int[][] res = new int[list.size()][2];
       for(int i = 0; i < list.size() ; i++){
           res[i][0] = list.get(i).start;
           res[i][1] = list.get(i).end;
       }

       return res;

    }

    public static void main(String[] args) {
        int[][] merge = new LeetCode53().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for(int[] a : merge){
            System.out.println(Arrays.toString(a));
        }

    }

}
