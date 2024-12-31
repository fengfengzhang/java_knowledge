package com.zhangfeng.juejin;

import java.util.HashMap;
import java.util.Map;

public class Solution29 {
    /**
     * 小D拿到了一个仅由 "abc" 三种字母组成的字符串。她每次操作会对所有字符同时进行以下变换：
     *
     * 将 'a' 变成 'bc'
     * 将 'b' 变成 'ca'
     * 将 'c' 变成 'ab'
     * 小D将重复该操作 k 次。你的任务是输出经过 k 次变换后，得到的最终字符串。
     *
     * 例如：对于初始字符串 "abc"，执行 2 次操作后，字符串将变为 "caababbcbcca"。
     * @param s
     * @param k
     * @return
     */

    public static String solution(String s, int k) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here

        Map<Character,String> map = new HashMap<>();

        map.put('a',"bc");
        map.put('b',"ca");
        map.put('c',"ab");
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < k ; i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < sb.length() ; j++){
              temp.append(map.get(sb.charAt(j)));
            }
            sb = temp;

        }


        return sb.toString();
    }

}
