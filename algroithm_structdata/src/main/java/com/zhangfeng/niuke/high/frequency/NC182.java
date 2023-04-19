package com.zhangfeng.niuke.high.frequency;

import java.util.*;

/**
 * @ClassName NC182
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/19 19:27
 */
public class NC182 {
    /**
     * 给定一个字符串 s 和一个字符串数组 dic ，在字符串 s 的任意位置添加任意多个空格后得到的字符串集合是给定字符串数组 dic 的子集（即拆分后的字符串集合中的所有字符串都在 dic 数组中），你可以以任意顺序 返回所有这些可能的拆分方案。
     */
    public String[] wordDiv (String s, String[] dic) {
        // write code here
        Set<String> set = new HashSet<>(Arrays.asList(dic));

       List<String> resList = new ArrayList<>();
       List<String> path = new ArrayList<>();
       dfs(resList,path,0,set,s);
       String[] res = new String[resList.size()];
       for(int i = 0; i < resList.size() ; i++){
           res[i] = resList.get(i);
       }
       return res;
    }

    public void dfs(List<String> resList, List<String> path, int index,Set<String> dic,String str){
        if(index == str.length()){
            resList.add(String.join(" ", path));
           return;
        }


        for(int i = index ; i < str.length() ; i++){
            String substring = str.substring(index, i + 1);
            if(dic.contains(substring)){
                path.add(substring);
                dfs(resList, path, i + 1, dic, str);
                if(path.size() > 0) path.remove(path.size() -1);

            }
        }
    }

    public static void main(String[] args) {
        NC182 nc182 = new NC182();
        System.out.println(Arrays.toString(nc182.wordDiv(
                "nowcoder", new String[]{"now", "coder", "no", "wcoder"})));
    }
}
