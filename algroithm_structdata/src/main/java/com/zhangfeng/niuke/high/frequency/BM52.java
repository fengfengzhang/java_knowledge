package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;

/**
 * @ClassName BM52
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/28 21:00
 */
public class BM52 {

    /**
     * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int temp = 0;
        for(int i = 0; i  <array.length ; i++){
            temp = temp ^ array[i];
        }

        int splitFlag = 1;
        while ((temp & splitFlag) ==0){
            splitFlag = 1 << splitFlag;
        }

        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < array.length ; i++){
            if((splitFlag & array[i]) == 0){
                num1 = num1 ^ array[i];
            }else{
                num2 = num2 ^ array[i];
            }
        }

        int[] res = new int[]{num1,num2};
        Arrays.sort(res);
        return  res;
    }
}
