package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC197
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/26 16:53
 */
public class NC197 {
    /**
     * 给定一个非负整数数组nums，假定最开始处于下标为0的位置，数组里面的每个元素代表下一跳能够跳跃的最大长度。如果能够跳到数组最后一个位置，则返回true，否则返回false。
     */
    public boolean canJump (int[] nums) {
        // write code here
        if(nums ==null || nums.length == 0 || nums.length == 1) return true;

        int search = 0;
        for(int i = 0; i < nums.length ; i++){
            if(search < i) return false;

            search = Math.max(search,nums[i] + i);

        }

        return search >= nums.length -1;


    }

    public static void main(String[] args) {
        NC197 nc197 = new NC197();
        System.out.println(nc197.canJump(new int[]{1, 0}));
    }

}
