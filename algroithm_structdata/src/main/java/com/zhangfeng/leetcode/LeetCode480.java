package com.zhangfeng.leetcode;

import java.util.*;


/**
 * @ClassName LeetCode480
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/12/9 10:02
 */
public class LeetCode480 {

    /**
     * 滑动窗口中位数
     */

    public class MedianSlidingQueue {
        public PriorityQueue<Long> minQueue;
        public PriorityQueue<Long> maxQueue;

        public Map<Long,Integer> deletMap;
        public int k;

        public int minQueueSize;
        public int maxQueueSize;

        public MedianSlidingQueue(int k){
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>((o1,o2) ->{
               return  o2.compareTo(o1);
            });
            deletMap = new HashMap<>();
            this.k = k;
        }


        //向堆中添加元素
        public void insert(long num){
           if(minQueue.isEmpty() || minQueue.peek() <= num){
               minQueue.add(num);
               minQueueSize ++;
           }else{
               maxQueue.add(num);
               maxQueueSize ++;
           }
           balance();
        }


        //删除堆中的元素
        public void delete(long num){
            if(deletMap.containsKey(num)){
                deletMap.put(num,deletMap.get(num) +1);
            }else{
                deletMap.put(num,1);
            }

            if(num >= minQueue.peek()){
                minQueueSize --;
                remove(minQueue);
            }else{
                remove(maxQueue);
                maxQueueSize --;
            }

            balance();
        }

        public void remove(PriorityQueue<Long> queue){
              while (!queue.isEmpty()){
                  if(deletMap.containsKey(queue.peek())){
                     long num = queue.poll();
                     deletMap.put(num,deletMap.get(num)-1);
                     if(deletMap.get(num) == 0){
                         deletMap.remove(num);
                     }
                  }else{
                      break;
                  }
              }

        }


        public double getMedian(){
           /* if(minQueueSize == maxQueueSize){
                return minQueueSize == 0 ? 0 : (minQueue.peek() + maxQueue.peek()) * 1.0/2;
            }
            PriorityQueue<Integer> queue = minQueueSize > maxQueueSize ? minQueue : maxQueue;
            return queue.peek();*/

            return  (k&1) == 1 ? minQueueSize > maxQueueSize ? minQueue.peek(): maxQueue.peek() : (maxQueue.peek() + minQueue.peek()) *1.0/2;
        }


        public void balance(){
            if(minQueueSize - maxQueueSize > 1){
                minQueueSize --;
                maxQueueSize ++;
                maxQueue.add(minQueue.poll());
                remove(minQueue);

                //删除可能把小顶堆和大顶堆某个数给删除了，小顶堆堆最小的数比大顶堆最大的数，逻辑不存在了，大顶堆数量多一个也尝试给到小顶堆，保证这个逻辑关系
            }else if(maxQueueSize - minQueueSize >= 1){
                maxQueueSize --;
                minQueueSize ++;
                minQueue.add(maxQueue.poll());
                remove(maxQueue);

            }
        }


    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        MedianSlidingQueue medianSlidingQueue = new MedianSlidingQueue(k);

        double[] res = new double[nums.length - k + 1];
        int index = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length ){
            medianSlidingQueue.insert(nums[right]);

            if(right - left >= k -1){
               res[index ++] = medianSlidingQueue.getMedian();
               medianSlidingQueue.delete(nums[left]);
               left ++;
            }

            right ++;
        }

        return  res;

    }

    public static void main(String[] args){
        LeetCode480 leetCode480 = new LeetCode480();
        System.out.println(Arrays.toString(leetCode480.medianSlidingWindow(new int[]{9,7,0,3,9,8,6,5,7,6},2)));
    }

}