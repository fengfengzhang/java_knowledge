package com.zhangfeng.niuke.offer;

import java.util.PriorityQueue;

/**
 * @ClassName Solution47
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 9:02
 */
public class Solution47 {

    /**
     * JZ49
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第 n个丑数。
     */
     public int GetUglyNumber_Solution(int index) {
         if(index == 0){
             return 0;
         }
        int[] dp = new int[index];
        dp[0] = 1;
        int i = 0;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (true){
            i = i + 1;
            if(i == index) break;
            dp[i] = Math.min(Math.min(dp[p1] * 2 ,dp[p2] * 3),dp[p3] * 5);
            if(dp[i] == dp[p1] * 2) p1 ++;
            if(dp[i] == dp[p2] * 3) p2 ++;
            if(dp[i] == dp[p3] * 5) p3 ++;

        }
        return dp[index -1];




     }

    private int function(int index) {
        int i =0;
        long res = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        while (queue.size() != 0){
            if(i == index) break;
            i ++;
            res = queue.poll();
            if(!queue.contains(res * 2L)){
                queue.add(res * 2L);
            }
            if(!queue.contains(res * 3L)){
                queue.add(res * 3L);
            }
            if(!queue.contains(res * 5L)){
                queue.add(res * 5L);
            }

        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution47().GetUglyNumber_Solution(1500));
    }

}
