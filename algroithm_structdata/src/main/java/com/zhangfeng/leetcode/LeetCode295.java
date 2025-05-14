package com.zhangfeng.leetcode;

import java.util.PriorityQueue;

public class LeetCode295 {


    /**
     * 295. 数据流的中位数
     * MedianFinder() 初始化 MedianFinder 对象。
     *
     * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
     *
     * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
     */
    public  class MedianFinder{

        //大顶堆
        PriorityQueue<Integer> maxQueue;
        //小顶堆
        PriorityQueue<Integer> minQueue;

        //小顶堆最小值 比大顶堆最大的值还大，大顶堆与小顶堆，元素数量，最多大一个

        public MedianFinder() {

            maxQueue = new PriorityQueue<>((o1,o2)->{
                return o2.compareTo(o1);
            });

            minQueue = new PriorityQueue<>();

        }

        public void addNum(int num) {
            if(minQueue.isEmpty()){
                minQueue.add(num);
                return;
            }

            if(minQueue.peek() <= num){
                minQueue.add(num);
            }else{
                maxQueue.add(num);
            }


            if(minQueue.size() - maxQueue.size() > 1){
                maxQueue.add(minQueue.poll());
                return;
            }


            if(maxQueue.size() - minQueue.size() > 1){
                minQueue.add(maxQueue.poll());
            }

        }

        public double findMedian() {
            if(maxQueue.size() == minQueue.size()){
                if(maxQueue.isEmpty()){
                    return 0;
                }else{
                    return (maxQueue.peek() + minQueue.peek())*1.0 /2;
                }
            }else{
               return maxQueue.size() > minQueue.size() ? maxQueue.peek() : minQueue.peek();
            }
        }
    }

}
