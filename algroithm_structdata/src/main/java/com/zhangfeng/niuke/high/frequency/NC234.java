package com.zhangfeng.niuke.high.frequency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NC234
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/21 21:57
 */
public class NC234 {
    /**
     * 给定一颗节点数为N的二叉树，求其最小深度。最小深度是指树的根节点到最近叶子节点的最短路径上节点的数量。
     * （注：叶子节点是指没有子节点的节点。）
     */

      public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }


    public int run (TreeNode root) {
        // write code here
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int n = 0;
        boolean flag = false;
        while (!queue.isEmpty()){
            if(flag) break;
            int size = queue.size();
            n ++;
            for(int i = 0; i < size ; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right !=null ){
                    queue.offer(node.right);
                }

                if(node.left == null && node.right == null ){

                    flag = true;
                    break;
                }
            }
        }

        return n;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        NC234 nc234 = new NC234();
        System.out.println(nc234.run(node1));

//        System.out.println(nc234.run(new TreeNode(0)));

    }

}
