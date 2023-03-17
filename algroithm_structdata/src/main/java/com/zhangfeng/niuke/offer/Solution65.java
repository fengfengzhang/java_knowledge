package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution65
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/17 15:52
 */
public class Solution65 {
    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
     * 1.若干空格
     * 2.（可选）一个符号字符（'+' 或 '-'）
     * 3. 数字，字母，符号，空格组成的字符串表达式
     * 4. 若干空格
     *
     * 转换算法如下:
     * 1.去掉无用的前导空格
     * 2.第一个非空字符为+或者-号时，作为该整数的正负号，如果没有符号，默认为正数
     * 3.判断整数的有效部分：
     * 3.1 确定符号位之后，与之后面尽可能多的连续数字组合起来成为有效整数数字，如果没有有效的整数部分，那么直接返回0
     * 3.2 将字符串前面的整数部分取出，后面可能会存在存在多余的字符(字母，符号，空格等)，这些字符可以被忽略，它们对于函数不应该造成影响
     * 3.3  整数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231的整数应该被调整为 −231 ，大于 231 − 1 的整数应该被调整为 231 − 1
     * 4.去掉无用的后导空格
     */
    public int StrToInt (String s) {
        // write code here
        char[] chars = s.trim().toCharArray();

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        boolean opFlag = false;
        int res = 0;
        for (int i = 0; i < chars.length ; i++){
            if(chars[i] == '-' || chars[i] == '+'){
                if(i != 0) break;
                opFlag = chars[i] == '-';
            }else if( chars[i] >= '0' && chars[i] <= '9'){
                int temp = max - res * 10 - (chars[i] - '0');
                if(!opFlag &( res > max / 10 || temp < 0)) return Integer.MAX_VALUE;
                if(opFlag && (res > max / 10)) return min;
                if(opFlag && (temp) < 0 ) return Integer.MIN_VALUE;
                if(opFlag && temp == 0 ) return -1 * Integer.MAX_VALUE;
                res = res * 10 + (chars[i] - '0');
            }else{
                break;
            }
        }
        return opFlag ? -1 * res :  res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution65().StrToInt("-2147483647"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

//        System.out.println(-2147483647);
    }


}
