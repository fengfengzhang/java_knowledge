package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Solution31
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 17:17
 */
public class Solution31 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。假设输入的数组的任意两个数字都互不相同。
     *
     * 数据范围： 节点数量 0 \le n \le 10000≤n≤1000 ，节点上的值满足 1 \le val \le 10^{5}1≤val≤10
     * 5
     *   ，保证节点上的值各不相同
     * 要求：空间复杂度 O(n)O(n) ，时间时间复杂度 O(n^2)O(n
     * 2
     *  )
     * 提示：
     * 1.二叉搜索树是指父亲节点大于左子树中的全部节点，但是小于右子树中的全部节点的树。
     * 2.该题我们约定空树不是二叉搜索树
     * 3.后序遍历是指按照 “左子树-右子树-根节点” 的顺序遍历
     * 4.参考下面的二叉搜索树，示例 1
     */

    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence == null || sequence.length ==0) return false;
        List<Integer> list = Arrays.stream(sequence).boxed().collect(Collectors.toList());
        return process(list);
    }


    public boolean process(List<Integer> list){
        if(list.size() == 0){
            return true;
        }

        Integer root = list.get(list.size() - 1);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int i;
        for(i = 0; i < list.size() - 1 ; i++){
            if(list.get(i) < root){
                left.add(list.get(i));
            }else{
                break;
            }
        }

        for(; i< list.size() - 1 ; i++){
            if(list.get(i) < root){
                return false;
            }else{
                right.add(list.get(i));
            }
        }

        return process(left) && process(right);

    }
}
