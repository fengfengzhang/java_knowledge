package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;

/**
 * @ClassName NC415
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 12:22
 */
public class NC415 {

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

    public ArrayList<TreeNode> BSTgenerate (int n) {
        // write code here
      return   process(1,n);
    }

    public ArrayList<TreeNode> process(int start,int end){
          ArrayList<TreeNode> list = new ArrayList<>();
          if(start > end){
              list.add(null);
              return list;
          }

          for(int i = start; i<=end ; i++){
              ArrayList<TreeNode> left = process(start, i - 1);
              ArrayList<TreeNode> right = process(i + 1, end);
              for(TreeNode p : left){
                  for (TreeNode q : right){
                      TreeNode node = new TreeNode(i);
                      node.left = p;
                      node.right = q;
                      list.add(node);
                  }
              }
          }

          return list;
    }

}
