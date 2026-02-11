package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode118
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/11 14:53
 */
import java.util.*;
public class LeetCode118 {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * @param numRows
     * @return
     */


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows < 1){
            return list;
        }

        List<Integer> itemList = new ArrayList<>();
        itemList.add(1);
        list.add(itemList);

        for(int i = 1; i < numRows; i++){
            List<Integer> preList  = list.get(i-1);
            List<Integer> curList = new ArrayList<Integer>();
            curList.add(1);
            for(int j = 0; j + 1 < preList.size() ; j++){
                curList.add(preList.get(j) + preList.get(j + 1));
            }

            curList.add(1);
            list.add(curList);
        }

        return list;
    }

}