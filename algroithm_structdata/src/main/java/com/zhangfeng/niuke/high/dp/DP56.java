package com.zhangfeng.niuke.high.dp;

import java.util.*;

/**
 * @ClassName DP56
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/4 18:47
 */
public class DP56 {

    /**
     * 你是一个经验丰富的小偷，经过上次在街边和湖边得手后你准备挑战一次自己，你发现了一个结构如二叉树的小区，小区内每个房间都存有一定现金，你观察到除了小区入口的房间以外每个房间都有且仅有一个父房间和至多两个子房间。
     * 问，给定一个二叉树结构的小区，如之前两次行动一样，你无法在不触动警报的情况下同时偷窃两个相邻的房间，在不触动警报的情况下最多的偷窃金额。
     */

    public static  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {
        TreeNode root = buildTree();
        if(root == null) return;
        int[] process = process(root);

        System.out.println(Math.max(process[0],process[1]));

    }


    public static int[] process(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left  = process(root.left);
        int[] right = process(root.right);
        return new int[]{ Math.max(left[0],left[1]) + Math.max(right[0],right[1])  ,root.val + left[0] + right[0]};
    }



    public static TreeNode buildTree(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = scanner.nextLine().split(" ");
        String[] parent = scanner.nextLine().split(" ");
        List<TreeNode> list = new ArrayList<>(n);
        for (String value : values) {
            list.add(new TreeNode(Integer.parseInt(value)));
        }

        for(int i = 0; i < parent.length ; i++){
            int p = Integer.parseInt(parent[i]);
            if(p == 0) continue;

            if(list.get(p - 1).left == null){
                list.get(p - 1).left = list.get(i);
            }else{
                list.get(p - 1).right = list.get(i);
            }

        }

        return list.get(0);
    }
}
