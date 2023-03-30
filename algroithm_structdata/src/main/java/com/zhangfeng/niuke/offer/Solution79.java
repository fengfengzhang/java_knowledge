package com.zhangfeng.niuke.offer;

import java.util.Arrays;

/**
 * @ClassName Solution79
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/30 21:13
 */
public class Solution79 {

    /**
     *输入一个长度为 n 整数数组，数组里面可能含有相同的元素，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，对奇数和奇数，偶数和偶数之间的相对位置不做要求，但是时间复杂度和空间复杂度必须如下要求。
     */

    public int[] reOrderArrayTwo (int[] array) {
        // write code here
        int left = 0;
        int right = array.length - 1;
        int temp;
        while (left < right){
            if((array[left] & 1) == 0){
               temp = array[left];
               array[left] = array[right];
               array[right] = temp;
               right --;
            }else{
                left ++;
            }

        }

        return array;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        System.out.println(Arrays.toString(solution79.reOrderArrayTwo(new int[]{1, 2, 3, 4})));
    }
}
