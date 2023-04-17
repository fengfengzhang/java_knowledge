package com.zhangfeng.niuke.high.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DP43
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/17 12:12
 */
public class DP43 {
    /**
     * 给定一个正整数n，请找出最少个数的完全平方数，使得这些完全平方数的和等于n。
     * 完全平方指用一个整数乘以自己例如1*1，2*2，3*3等，依此类推。若一个数能表示成某个整数的平方的形式，则称这个数为完全平方数。例如:1，4，9，和16都是完全平方数，但是2，3，5，8，11等等不是
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
       dp[0] = 0;
       for(int i =1 ; i * i <= n ;i++){
           for(int j = i*i; j <= n ; j++){
              dp[j] = Math.min(dp[j],dp[j-i*i] + 1);
           }
       }

        System.out.println(dp[n]);
    }

}
