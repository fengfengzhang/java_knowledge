package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode108
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/12/10 18:19
 */


public class LeetCode108 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  // 有序数组转化成平衡的二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
         if(nums == null){
             return null;
         }

         return process(nums);
    }


    public TreeNode process(int[] nums){
        if(nums.length == 0){
            return  null;
        }

        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        int[][] res = splitArray(nums);
        int val = nums[(nums.length-1)/2];

        TreeNode left =  process(res[0]);
        TreeNode right = process(res[1]);
        return new TreeNode(val,left,right);

    }


    public int[][] splitArray(int[] nums){
        int mid = (nums.length -1)/2;
        int[][] res = new int[2][];

        int[] arr1 = new int[mid];
        int[] arr2 = new int[nums.length - mid - 1];

        for(int i = 0; i <mid ;i++){
            arr1[i] = nums[i];
        }

        for(int i = 0; i< arr2.length ; i++){
            arr2[i] = nums[i + mid +1];
        }

        res[0] = arr1;
        res[1] = arr2;

        return res;
    }

}