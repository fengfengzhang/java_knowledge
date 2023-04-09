package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM32
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/9 13:41
 */
public class BM32 {
    /**
     * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。例如：
     */
      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
      }

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        return process(t1,t2);
    }

    public TreeNode process(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 != null){
            return t2;
        }

        if(t1 != null && t2 ==null){
            return t1;
        }
       if(t1!= null && t2 != null){
          t1.val += t2.val;
          TreeNode leftNoe = process(t1.left,t2.left);
          TreeNode rightNode = process(t1.right,t2.right);
          t1.left = leftNoe;
          t1.right = rightNode;
          return t1;
       }

       return null;

    }




}
