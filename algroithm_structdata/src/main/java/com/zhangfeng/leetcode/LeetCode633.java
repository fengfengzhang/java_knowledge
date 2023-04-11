package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode633
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 20:39
 */
public class LeetCode633 {

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     */

    public boolean judgeSquareSum(int c) {
         long left = 0;
         long right = (long)Math.sqrt(c);
         while (left <= right){
             long sum = left * left + right *right;
             if(sum == c){
                 return true;
             }else if(sum > c){
                 right --;
             }else{
                 left ++;
             }
         }
         return false;
    }

    public static void main(String[] args) {
        LeetCode633 leetCode633 = new LeetCode633();
        System.out.println(leetCode633.judgeSquareSum(2147483600));
    }
}
