package com.zhangfeng.niuke.high.frequency;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NC100
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/8 12:57
 */
public class NC100 {
    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
     * 1.若干空格
     * 2.（可选）一个符号字符（'+' 或 '-'）
     * 3. 数字，字母，符号，空格组成的字符串表达式
     * 4. 若干空格
     */
    public int StrToInt (String s) {
        // write code here
        if(s == null ) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean flag = false;
        if(s.charAt(0) != '+' && s.charAt(0) != '-' && !(s.charAt(0) >= '0' && s.charAt(0)<='9')) return 0;
        int item = 0;
        for(int i = 0; i < s.length() ; i++){
            if(i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+')){
                flag = s.charAt(i) == '-';
                continue;
            }
            if(!(s.charAt(i)>= '0' && s.charAt(i)<= '9')) break;
            if(flag){
                if(item - 1 >= (Integer.MAX_VALUE - (s.charAt(i) - '0'))/10){
                    item = Integer.MIN_VALUE;
                }else {
                    item = item * 10 + s.charAt(i) - '0';
                }

            }else{
                if(item >= (Integer.MAX_VALUE - (s.charAt(i) - '0'))/10){
                    item = Integer.MAX_VALUE;
                    break;
                }else{
                    item = item * 10 + s.charAt(i) - '0';
                }

            }

        }

        return item * (flag ? -1 : 1);

    }

    public static void main(String[] args) {
        NC100 nc100 = new NC100();
        System.out.println(nc100.StrToInt("-+5"));
    }
}
