package com.zhangfeng.juejin;

import java.util.HashMap;
import java.util.Map;

public class Solution29 {

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
