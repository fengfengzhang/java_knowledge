package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BM41
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/18 17:28
 */
public class BM41 {

    /**
     * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
     */

    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode node = buildTree(xianxu, zhongxu);
        if(node == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
                if(i == size -1) list.add(poll.val);
            }

        }

        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;


    }


    public TreeNode buildTree(int[] pre,int[] mid){
          if(pre.length == 0 || mid.length == 0){
              return null;
          }

        int rootVal = pre[0];
        TreeNode node = new TreeNode(rootVal);

        List<int[]> splitArray = splitArray(pre, mid);

        TreeNode leftNode = buildTree(splitArray.get(0),splitArray.get(1));

        TreeNode rightNode = buildTree(splitArray.get(2),splitArray.get(3));
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }


    public List<int[]> splitArray(int[] pre,int[] mid){
        int root = pre[0];

        int leftLength = 0;
        int rightLength = 0;
        for(int i = 0; i < mid.length ; i++){
            if(root == mid[i]){
                break;
            }
            leftLength ++;
        }

        rightLength = mid.length - leftLength - 1;
        int[] leftPreArray = new int[leftLength];
        int[] rightPreArray = new int[rightLength];

        int[] leftMidArray = new int[leftLength];
        int[] rightMidArray = new int[rightLength];

        for(int i = 0; i < leftPreArray.length ; i++){
            leftPreArray[i] =  pre[i+1];
        }

        for(int i = 0 ; i< rightPreArray.length ; i++){
            rightPreArray[i] = pre[i + leftLength + 1];
        }

        for(int i = 0; i < leftMidArray.length ; i++){
            leftMidArray[i] = mid[i];
        }

        for(int i = 0; i < rightMidArray.length ; i++){
            rightMidArray[i] = mid[i+1+leftLength];
        }

        List<int[]> list = new ArrayList<>();
        list.add(leftPreArray);
        list.add(leftMidArray);
        list.add(rightPreArray);
        list.add(rightMidArray);

        return list;
    }


}
