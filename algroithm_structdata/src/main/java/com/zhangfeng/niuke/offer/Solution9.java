package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution9
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 19:01
 */
public class Solution9 {
    /**
     * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
     * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
     *
     * 数据范围：1 \le n \le 100001≤n≤10000，数组中任意元素的值: 0 \le val \le 100000≤val≤10000
     * 要求：空间复杂度：O(1)O(1) ，时间复杂度：O(logn)O(logn)
     */
    public int minNumberInRotateArray(int [] array) {
         //类似二分查找。中间值如果比区间右边大则目标在右侧区间
        //如果比区间右边小则在左侧区间，等于的话右侧区间减一，等于可能有多个相等的，区间左右相等则找到
        int left = 0;
        int right = array.length - 1;
        while (left != right){
            int mid = (left + right) / 2;
            if(array[mid] > array[right]){
                left = mid + 1;
            }else if(array[mid] == array[right]){
                right --;
            }else{
                right = mid;
            }
        }

        return array[left];

    }
}
