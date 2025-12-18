package com.zhangfeng.leetcode;

/**
 * @ClassName LeeCode100
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/12/16 11:29
 */
public class LeetCode100 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int left =0;
        int right = height.length - 1;

        int leftHigh = height[left];
        int rightHigh = height[right];
        int res = 0;
        while(left <= right){
            int h = Math.min(leftHigh,rightHigh);
            if(leftHigh < rightHigh){
                if(height[left] < h){
                    res += h - height[left];
                }else{
                    leftHigh = Math.max(height[left],leftHigh);
                }
                left ++;
            }else{
                if(height[right] < h){
                    res += h - height[right];
                }else{
                    rightHigh = Math.max(height[right],rightHigh);
                }
                right --;
            }
        }
        return  res;

    }

    public static void main(String[] args) {
        LeetCode100 leeCode100 = new LeetCode100();
        System.out.println(leeCode100.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}