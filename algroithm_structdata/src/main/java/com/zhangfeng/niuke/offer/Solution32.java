package com.zhangfeng.niuke.offer;

import java.util.ArrayList;

/**
 * @ClassName Solution32
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 8:02
 */
public class Solution32 {


     public static class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }

     }

    /**
     * JZ34
     * 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
     * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
     * 2.叶子节点是指没有子节点的节点
     * 3.路径只能从父节点到子节点，不能从子节点到父节点
     * 4.总节点数目为n
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
           ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
           ArrayList<Integer> list = new ArrayList<>();
           process(root,expectNumber,resList,list);
//           process1(resList,list,expectNumber,root);
           return resList;
    }


    public void process(TreeNode root, int expectNumber,ArrayList<ArrayList<Integer>> resList,ArrayList<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null){
             int sum = 0;
             for(int i = 0; i < list.size() ; i++){
                 sum += list.get(i);
             }
             if(sum == expectNumber){
                resList.add(new ArrayList<>(list));
             }

        }

        process(root.left,expectNumber,resList,list);
        process(root.right,expectNumber,resList,list);
        if(list.size() > 0){
            list.remove(list.size() -1);
        }

    }




    public static void main(String[] args) {
       /* TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;*/

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-1);
        TreeNode node3 = new TreeNode(-5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(-5);
        TreeNode node7 = new TreeNode(-1);
        TreeNode node8 = new TreeNode(-4);
        TreeNode node9 = new TreeNode(-5);

        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node3.right= node5;
        node4.right = node6;
        node6.right = node8;
        node5.right = node7;
        node7.left = node9;


        System.out.println(new Solution32().FindPath(node1, -10));
    }

}
