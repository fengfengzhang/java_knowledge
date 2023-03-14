package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution52
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 18:34
 */
public class Solution52 {

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

    /**
     * JZ54
     *给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
     * 1.返回第k小的节点值即可
     * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
     * 3.保证n个节点的值不一样
     */

    public int KthNode (TreeNode proot, int k) {
        if(proot == null) return  -1;
        // write code here
        List<Integer> list = new ArrayList<>();
        process(proot,list);
       return list.size() < k ? -1 : list.get(k-1);
      }

    public void process(TreeNode root, List<Integer> sequence){
          if(root == null) return;
          process(root.left,sequence);
          sequence.add(root.val);
          process(root.right,sequence);
      }

}
