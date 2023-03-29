package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM93
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/29 14:14
 */
public class BM93 {
    /**
     * 给定一个数组height，长度为n，每个数代表坐标轴中的一个点的高度，height[i]是在第i点的高度，请问，从中选2个高度与x轴组成的容器最多能容纳多少水
     * 1.你不能倾斜容器
     * 2.当n小于2时，视为不能形成容器，请返回0
     * 3.数据保证能容纳最多的水不会超过整形范围，即不会超过231-1
     */
    public int maxArea (int[] height) {
        // write code here
       if(height == null || height.length < 2) return 0;
       int left = 0;
       int right = height.length - 1;
       int leftMax = height[left];
       int rightMax = height[right];
       int max = 0;

       while (left < right){
           max =Math.max(max,Math.min(leftMax,rightMax)*(right - left));
           if(leftMax < rightMax){
               left ++;
               leftMax = Math.max(leftMax,height[left]);
           }else{
               right --;
               rightMax = Math.max(rightMax,height[right]);
           }

       }
       return max;
    }

    public static void main(String[] args) {
        BM93 bm93 = new BM93();
        System.out.println(bm93.maxArea(new int[]{1,7,3,2,4,5,8,2,7}));
    }

}
