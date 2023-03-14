package com.zhangfeng.niuke.offer;

import java.util.*;

/**
 * @ClassName Solution73
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 10:44
 */
public class Solution73 {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g" 。当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符是"l"。
     *
     * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，字符串中出现的字符一定在 ASCII 码内。
     * 进阶：空间复杂度 O(n)\O(n)  ，时间复杂度 O(n) \O(n)
     */

   Map<Character,Integer> map = new HashMap<>();
   List<Character> list = new ArrayList<>();


    public void Insert(char ch)
    {
       if(map.containsKey(ch)){
           map.put(ch,map.get(ch) + 1);
       }else{
           map.put(ch,1);
           list.add(ch);
       }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Character character : list){
            if(map.get(character) == 1){
                return character;
            }
        }
       return '#';
    }


    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();

        solution73.Insert('g');
        System.out.println(solution73.FirstAppearingOnce());
        solution73.Insert('o');
        System.out.println(solution73.FirstAppearingOnce());
        solution73.Insert('o');
        System.out.println(solution73.FirstAppearingOnce());
        solution73.Insert('g');
        System.out.println(solution73.FirstAppearingOnce());
        solution73.Insert('l');
        System.out.println(solution73.FirstAppearingOnce());
        solution73.Insert('e');
        System.out.println(solution73.FirstAppearingOnce());
    }

}
