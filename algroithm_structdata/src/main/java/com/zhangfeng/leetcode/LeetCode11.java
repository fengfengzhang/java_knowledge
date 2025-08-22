package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode11
 * @Description 盛水最多的容器
 * @Author zhangfeng
 * @Date 2025/8/22 17:36
 */
public class LeetCode11 {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     * @param height
     * @return
     */

    public int maxArea(int[] height) {

        int left = 0 ;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int res = 0;

        while(left != right){

            res = Math.max(res,Math.min(leftMax,rightMax) * (right - left));

            if(leftMax < rightMax){
                left ++;
                leftMax = height[left];
            }else{
                right --;
                rightMax = height[right];
            }

        }

        return res;

    }


    public static void main(String[] args) {
        System.out.println(new LeetCode11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}