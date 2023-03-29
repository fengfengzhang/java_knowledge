package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM94
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/29 13:58
 */
public class BM94 {

    /**
     * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。(数组以外的区域高度视为0)
     */

    public long maxWater (int[] arr) {
        // write code here
        if(arr == null || arr.length < 3) return  0;

        int left = 0;
        int right = arr.length - 1;
        int leftMax = arr[left];
        int rightMax = arr[right];
        long sum = 0;
        while (left < right){
            if(leftMax < rightMax){
                left ++;
                if(arr[left] < leftMax){
                    sum += leftMax - arr[left];
                }else{
                    leftMax = arr[left];
                }

            }else{
                right --;
                if(arr[right] < rightMax){
                    sum += rightMax - arr[right];
                }else{
                    rightMax = arr[right];
                }

            }


        }
        return sum;
    }

    public static void main(String[] args) {
        BM94 bm94 = new BM94();
        System.out.println(bm94.maxWater(new int[]{3,1,2,5,2,4}));
    }


}
