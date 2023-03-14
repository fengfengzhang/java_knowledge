package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution42
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 15:06
 */
public class Solution42 {
    /**
     * JZ44
     * 数字以 0123456789101112131415... 的格式作为一个字符序列，在这个序列中第 2 位（从下标 0 开始计算）是 2 ，第 10 位是 1 ，第 13 位是 1 ，以此类题，请你输出第 n 位对应的数字。
     *
     * 数据范围： 0 \le n \le 10^9 \0≤n≤10
     * 9
     *
     */
    public int findNthDigit (int n) {
        long start = 1;
        int digit = 1;
        long sum = 9;
        while (sum < n) {
            n -= sum;
            start = start * 10;
            digit ++;
            sum = 9 * start * digit;
        }

        String num =String.valueOf( start + (n - 1) / digit);
        int index = (n-1)%digit;

        return (int)(num.charAt(index)) - (int)('0');
    }

    public static void main(String[] args) {
//        System.out.println(new Solution42().findNthDigit(2));
        System.out.println(new Solution42().findNthDigit(1000000000));
    }



}
