package com.zhangfeng.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode230
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/12/10 18:32
 */
public class LeetCode230 {

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


   //二叉搜索树第k小
    public int kthSmallest(TreeNode root, int k) {
       List<Integer> list =   new ArrayList<Integer>();

       process(root,list,k);

       if(list.size() >= k && k > 0){

           return list.get(k-1);
       }

       return  0;
    }



    public void process(TreeNode root, List<Integer> list, int k){
        if(root.left != null){
            process(root.left,list,k);
        }

        list.add(root.val);
        if(root.right != null){
            process(root.right,list,k);
        }


    }
}