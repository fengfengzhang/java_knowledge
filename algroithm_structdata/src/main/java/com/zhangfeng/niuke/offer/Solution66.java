package com.zhangfeng.niuke.offer;

import java.util.ArrayList;

/**
 * @ClassName Solution65
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 13:21
 */
public class Solution66 {
    /**
     * JZ68
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
     * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
     * 3.所有节点的值都是唯一的。
     * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
     * 数据范围:
     * 3<=节点总数<=10000
     * 0<=节点值<=10000
     */

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        if(root == null) return -1;

        int max = Math.max(p,q);
        int min = Math.min(p,q);
        if(root.val >= min && root.val <= max){
            return root.val;
        }else if(root.val < min){
            return lowestCommonAncestor(root.right,max,min);
        }else{
            return lowestCommonAncestor(root.left,max,min);
        }
      }


}
