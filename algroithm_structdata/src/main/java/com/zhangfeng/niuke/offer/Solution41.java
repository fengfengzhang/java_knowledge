package com.zhangfeng.niuke.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution43
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 12:26
 */
public class Solution41 {

    /**
     * JZ43
     * 描述
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     *
     * 数据范围：数据流中数个数满足 1 \le n \le 1000 \1≤n≤1000  ，大小满足 1 \le val \le 1000 \1≤val≤1000
     *
     * 进阶： 空间复杂度 O(n) \O(n)  ， 时间复杂度 O(nlogn) \O(nlogn)
     */


    public PriorityQueue<Integer> minHeapQueue = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeapQueue = new PriorityQueue<>(Comparator.reverseOrder());
    public void Insert(Integer num) {
        addNumber(num);
    }

    public Double GetMedian() {
        if(minHeapQueue.size() == 0 && maxHeapQueue.size() == 0){
            return 0.0;
        }


        if(minHeapQueue.size() == maxHeapQueue.size()){
          return   (minHeapQueue.peek()  + maxHeapQueue.peek())*1.0/2;
        }

        return minHeapQueue.size() > maxHeapQueue.size() ? Double.valueOf(minHeapQueue.peek()) : Double.valueOf(maxHeapQueue.peek());

    }

    public void addNumber(Integer num){
        if(minHeapQueue.isEmpty()){
            minHeapQueue.add(num);
            return;
        }

        if(minHeapQueue.peek() <= num){
            minHeapQueue.add(num);
        }else{
            maxHeapQueue.add(num);
        }

        if(Math.abs(minHeapQueue.size() - maxHeapQueue.size()) > 1){
            PriorityQueue<Integer> addQueue = minHeapQueue.size() > maxHeapQueue.size() ? maxHeapQueue : minHeapQueue;
            PriorityQueue<Integer> removeQueue = minHeapQueue.size() > maxHeapQueue.size() ? minHeapQueue : maxHeapQueue;
            addQueue.add(removeQueue.poll());
        }
    }
}
