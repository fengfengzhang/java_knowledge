package com.zhangfeng.leetcode;

import java.util.*;

/**
 * @ClassName LeetCode17
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/7/11 14:39
 */
public class LeetCode17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
     * @param digits
     * @return
     */

    Map<Character,List<Character>> map = new HashMap<Character,List<Character>>(){{
        put('2', Arrays.asList('a', 'b','c'));
        put('3', Arrays.asList('d', 'e','f'));
        put('4', Arrays.asList('g', 'h','i'));
        put('5', Arrays.asList('j', 'k','l'));
        put('6', Arrays.asList('m', 'n','o'));
        put('7', Arrays.asList('p', 'q','r','s'));
        put('8', Arrays.asList('t', 'u','v'));
        put('9', Arrays.asList('w', 'x','y','z'));

    }};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();
        process(list,tempList,digits,0);
        return list;

    }


    public void process(List<String> list,List<Character> tempList,String digits,int k){
        if(k == digits.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < tempList.size() ;i ++){
                sb.append(tempList.get(i));
            }
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
            return;
        }

        List<Character> characters = map.get(digits.charAt(k));
        for(int j = 0;j < characters.size();j++){
            tempList.add(characters.get(j));
            process(list,tempList,digits,k +1);
            if(!tempList.isEmpty()){
                tempList.remove(tempList.size() - 1);
            }
        }




    }


    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }

}