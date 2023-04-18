package com.zhangfeng.niuke.high.frequency;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName NC334
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/18 20:17
 */
public class NC334 {
    /**
     * 给定正整数 n 和 k ，请你找出 [1,n] 内的字典序第 k 小的数。
     */
   /* public int findKth (int n, int k) {
        // write code here
        Comparator<Integer> comparator = (o1, o2) -> {
          String str1 = String.valueOf(o1);
          String str2 = String.valueOf(o2);
          int len1 = 0;
          int len2 = 0;
          while (len1 < str1.length() && len2 < str2.length()){
              if(str1.charAt(len1) != str2.charAt(len2))
                  return str2.charAt(len2) - str1.charAt(len1) ;
              len1 ++;
              len2 ++;
          }
          return len1 == str1.length() ? 1 : -1;
        };

        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

        for(int i = 1; i <= n ; i++){
            if(queue.size() < k){
                queue.add(i);
            }else {
                if (comparator.compare(queue.peek(),i) < 0){
                    queue.poll();
                    queue.add(i);
                }
            }
        }

        return queue.peek();

    }
*/

    public int findKth (int n, int k) {
        long cur = 1;
        k -= 1;
        while (k > 0) {
            long nodes = getNodes(cur, n);
            if (k < nodes) {
                k -= 1;
                cur *= 10;
            } else {
                k -= nodes;
                cur ++;
            }
        }
        return (int)cur;
    }


    public long getNodes(long cur, long n) {
        long next = cur + 1;
        long total = 0;
        while (cur <= n) {
            total += Math.min(n - cur + 1, next - cur);
            cur *= 10;
            next *= 10;
        }

        return total;
    }


    public static void main(String[] args) {
        NC334 nc334 = new NC334();
        System.out.println(nc334.findKth(
                10,7));
    }


}
