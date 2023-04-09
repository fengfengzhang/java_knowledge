package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM37
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/9 13:51
 */
public class BM37 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
     * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
     * 3.所有节点的值都是唯一的。
     * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
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
        if(root == null ) return  0;
        int min = Math.min(p,q);
        int max = Math.max(p,q);

        return process(root,min,max);
    }


    public int process(TreeNode root,int p, int q){
         if(root.val >= p && root.val <= q){
             return root.val;
         }else if(root.val < p){
             return process(root.right,p,q);
         }else{
             return process(root.left,p,q);
         }
    }
}
