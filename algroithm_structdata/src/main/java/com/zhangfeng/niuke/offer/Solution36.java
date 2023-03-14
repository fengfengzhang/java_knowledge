package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * @ClassName Solution36
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 14:36
 */
public class Solution36 {
    /**
     * JZ38
     * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
     * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
     */

    public Set<String> set = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() == 0){
            return list;
        }
        process(str.toCharArray(),0,list);
        return list;

    }

    public void process(char[] str , int setup,List<String> list){
         if(setup == str.length){
             String s = new String(str);
             if(!set.contains(s)){
                   list.add(s);
                   set.add(s);
             }
         }

         for(int i = setup ; i < str.length ; i++){
             swap(str,setup,i);
             process(str,setup + 1,list);
             swap(str,setup,i);
         }

    }

    private void swap(char[] str, int setup, int i) {
         char temp = str[setup];
         str[setup] = str[i];
         str[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution36().Permutation("ab"));
    }
}


