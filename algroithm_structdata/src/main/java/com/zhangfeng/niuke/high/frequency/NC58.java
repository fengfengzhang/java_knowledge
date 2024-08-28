package com.zhangfeng.niuke.high.frequency;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值。(每个节点的值各不相同)
 * 搜索二叉树：满足每个节点的左子节点小于当前节点，右子节点大于当前节点。
 */
public class NC58 {

      public static class TreeNode {
       int val = 0;
       TreeNode left = null;
       TreeNode right = null;
       public TreeNode(int val) {
          this.val = val;
        }
     }

     TreeNode preNode;
     int[] res = new int[2];
     int index = 1;

    public int[] findError (TreeNode root) {
        // write code here

      process(root);
      return res;
    }

    public void process(TreeNode node){
          if(node == null) return;

          process(node.left);

          if(preNode == null){
              preNode = node;
          }

          if( index == 1 && preNode.val > node.val){

              res[index] = preNode.val;
              index --;
          }

          //最后一个大于当前结点的
          if(index == 0 && preNode.val > node.val){
              res[index] = node.val;
          }
          preNode = node;

          process(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        int[] error = new NC58().findError(root);
        System.out.println(Arrays.toString(error));

    }

}
