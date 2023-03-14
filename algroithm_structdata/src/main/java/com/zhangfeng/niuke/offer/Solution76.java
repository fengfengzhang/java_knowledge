package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution76
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 12:00
 */
public class Solution76 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * JZ78
     * 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，同一层结点从左至右输出，每一层输出一行，将输出的结果存放到一个二维数组中返回。
     * 例如：
     * 给定的二叉树是{1,2,3,#,#,4,5}
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
       ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
       if(pRoot == null) return  resList;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(pRoot);
       while (!queue.isEmpty()){
           int size = queue.size();
           ArrayList<Integer> list = new ArrayList<>();
           for(int i = 0; i < size ; i++){
               TreeNode node = queue.poll();
               list.add(node.val);
               if(node.left != null){
                   queue.add(node.left);
               }

               if(node.right != null){
                   queue.add(node.right);
               }

           }

           resList.add(list);
       }

       return resList;



    }


}
