package com.zhangfeng.niuke.high.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName DP55
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/19 14:33
 */
public class DP55 {
    /**
     * 二叉树里面的路径被定义为:从该树的任意节点出发，经过父=>子或者子=>父的连接，达到任意节点的序列。
     * 注意:
     * 1.同一个节点在一条二叉树路径里中最多出现一次
     * 2.一条路径至少包含一个节点，且不一定经过根节点
     */

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    private int sum = Integer.MIN_VALUE;




    public int culMaxPathSumInTree(TreeNode root){
        if(root == null) return 0;

        //不必是叶子节点，当出现负数时候，先返回0
        int left = Math.max(0,culMaxPathSumInTree(root.left));
        int right = Math.max(0,culMaxPathSumInTree(root.right));

        //当前节点进行一次结算，从左到当前到右，这个子结构是否更新了最大值
        sum = Math.max(sum,  root.val +left + right);

        //返回给上层节点，必须是当前节点和左右子树中的一条。
        return root.val + Math.max(left,right);

    }

    public TreeNode buildTree(){
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






    public static void main(String[] args) {
        DP55 dp55 = new DP55();
        TreeNode treeNode = dp55.buildTree();
        dp55.culMaxPathSumInTree(treeNode);
        System.out.println(dp55.sum);
    }

}
