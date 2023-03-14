package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution40
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 12:46
 */
public class Solution40 {

    /**
     * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
     * 数据范围:
     * 1 <= n <= 2\times10^51<=n<=2×10
     * 5
     *
     * -100 <= a[i] <= 100−100<=a[i]<=100
     *
     * 要求:时间复杂度为 O(n)O(n)，空间复杂度为 O(n)O(n)
     * 进阶:时间复杂度为 O(n)O(n)，空间复杂度为 O(1)O(1)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
           //最大的子数组和，必须以一个不为0的前缀开始
        int temp = 0;
        int max = array[0];

        for(int i = 0; i < array.length ; i++){
            temp += array[i];
            max = Math.max(temp,max);
            if(temp < 0){
                temp = 0;
            }
        }
        return max;
    }
}
