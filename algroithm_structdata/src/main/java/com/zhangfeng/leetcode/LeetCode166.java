package com.zhangfeng.leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode166
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/10 12:41
 */
public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
         StringBuilder sb = new StringBuilder();
         HashMap<Long, Integer> map = new HashMap<>();
         long a = numerator;
         long b = denominator;
         if(a*b < 0) sb.append('-');
         a = Math.abs(a);
         b = Math.abs(b);
         sb.append(a/b);
         if(a % b == 0) return sb.toString();
         sb.append('.');
         while ((a = (a%b) * 10) > 0 &&!map.containsKey(a)){
             map.put(a,sb.length());
             sb.append(a/b);
         }
         if(a == 0) return sb.toString();
         return sb.insert(map.get(a).intValue(), '(').append(')').toString();
    }

    public static void main(String[] args) {
        LeetCode166 leetCode166 = new LeetCode166();
        System.out.println(leetCode166.fractionToDecimal(5, 43));
    }
}
