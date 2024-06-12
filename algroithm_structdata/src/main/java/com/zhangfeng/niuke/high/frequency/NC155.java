package com.zhangfeng.niuke.high.frequency;

public class NC155 {

    /**
     * 给定一个长度为n的正整数数组nums，可以任意改变数组的其中一个元素，改变的元素范围也在[1,100000]之内，然后返回nums的最长"严格上升"子数组的长度。
     * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     * 2.严格上升指在数组上任意位置都满足 nums[i] < nums[i+1]，比如[1,2,2,3]，其中[1,2,2]不是严格上升的子数组，[1,2]是的
     * 数据范围：
     * 1
     * ≤
     * 𝑛
     * ≤
     * 1
     * 0
     * 5
     *
     * 1≤n≤10
     * 5
     *    ，
     * 1
     * ≤
     * 𝑛
     * 𝑢
     * 𝑚
     * [
     * 𝑖
     * ]
     * ≤
     * 1
     * 0
     * 5
     *
     * 1≤num[i]≤10
     * 5
     *
     * 要求： 空间复杂度
     * 𝑂
     * (
     * 𝑛
     * )
     *
     * O(n) ，时间复杂度
     * 𝑂
     * (
     * 𝑛
     * )
     *
     * O(n)
     */

    public int maxSubArrayLengthTwo (int[] nums) {
        // write code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        int[] dpLeft = new int[nums.length]; //必须以当前位置结尾的最长子数组长度
        int[] dpRight = new int[nums.length]; //必须以当前位置开始的最长子数组长度

        dpLeft[0] = 1;

        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > nums[i-1]){
                dpLeft[i] = dpLeft[i-1] + 1;
            }else{
                dpLeft[i] = 1;
            }

        }

        dpRight[nums.length - 1] = 1;
        for(int i = nums.length - 2; i>= 0 ; i--){
            if(nums[i+1] > nums[i]){
                dpRight[i] = dpRight[i+1] + 1;
            }else{
                dpRight[i] = 1;
            }
        }

        int length = 1;
        for(int i = 0; i < nums.length ; i++){

            if(i >0 && i< nums.length -1 && nums[i + 1] > nums[i-1] + 1){
                length = Math.max(dpRight[i + 1] + dpLeft[i-1] + 1, length);
            }else{
                if(i > 0){
                    length = Math.max(dpLeft[i-1] + 1,length);
                }

                //结算i位置时候，i+ 1位置必须大于1否则是1的话，i位置没法改成0，正数子数组
                if(i < nums.length -1 && nums[i + 1] > 1){
                    length = Math.max(dpRight[i + 1] + 1,length);
                }
            }
        }

        return length;

    }

    public static void main(String[] args) {
        System.out.println(new NC155().maxSubArrayLengthTwo(new int[]{1, 1, 2, 3}));
    }


}
