package com.zhangfeng.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @ClassName LeetCode22
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/10/27 15:19
 */
public class LeetCode22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public List<String> generateParenthesis(int n) {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        ArrayList<Character> tempList = new ArrayList<>();
        process(hashSet,tempList,0,0,n,0);
        return new ArrayList<>(hashSet);

    }




    public void process(LinkedHashSet<String> resSet, ArrayList<Character> tempList, int leftNum, int rightNum , int n, int k){

        if(k ==  2 * n){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < tempList.size(); i++){
                sb.append(tempList.get(i));
            }
            resSet.add(sb.toString());


            return;
        }


        if(leftNum < n){
            tempList.add('(');
            process(resSet,tempList,leftNum + 1,rightNum,n,k + 1);
            if(!tempList.isEmpty()){
                tempList.remove(tempList.size() - 1);
            }

        }

        if(leftNum > rightNum){
            tempList.add(')');
            process(resSet,tempList,leftNum,rightNum + 1,n,k+1);
            if(!tempList.isEmpty()){
                tempList.remove(tempList.size() - 1);
            }
        }





        return;

    }


    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        ArrayList<Character> tempList = new ArrayList<>();
        leetCode22.process(hashSet,tempList,0,0,3,0);
        System.out.println(hashSet);
    }

}