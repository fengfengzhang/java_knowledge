package com.zhangfeng.niuke.offer;

import java.util.ArrayList;

/**
 * @ClassName Solution5
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 17:50
 */
public class Solution5 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     *
     * JZ7
     * 描述
     * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
     *
     *
     * 提示:
     * 1.vin.length == pre.length
     * 2.pre 和 vin 均无重复元素
     * 3.vin出现的元素均出现在 pre里
     * 4.只需要返回根结点，系统会自动输出整颗树做答案对比
     * 数据范围：n \le 2000n≤2000，节点的值 -10000 \le val \le 10000−10000≤val≤10000
     * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        //递归创建，分割数组

        if(pre == null || pre.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        ArrayList<int[]> list = splitTreeArray(pre, vin);

        TreeNode left = reConstructBinaryTree(list.get(0), list.get(1));
        TreeNode right = reConstructBinaryTree(list.get(2),list.get(3));
        node.left = left;
        node.right = right;
        return node;
    }


    public ArrayList<int[]> splitTreeArray(int[] pre, int[] vin){
        int splitValue = pre[0];
        int leftLength = 0;
        int rightLength = 0;
        for(int i = 0; i < vin.length ; i++){
            if(vin[i] == splitValue){
                leftLength = i;
                rightLength = vin.length - i - 1;
                break;
            }
        }
        int[] leftPre = new int[leftLength];
        int[] leftVin = new int[leftLength];
        int[] rightPre = new int[rightLength];
        int[] rightVin = new int[rightLength];

        for(int i = 0; i < leftLength ; i++){
            leftPre[i] = pre[i + 1];
            leftVin[i] = vin[i];
        }

        for(int i = 0; i < rightLength ; i++){
            rightPre[i] = pre[i + leftLength + 1];
            rightVin[i] = vin[i + leftLength + 1];
        }


        ArrayList<int[]> res = new ArrayList<>();
        res.add(leftPre);
        res.add(leftVin);
        res.add(rightPre);
        res.add(rightVin);
        return res;

    }
}
