package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution18
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/17 14:44
 */
public class Solution18 {
    /**
     * JZ20
     * 请实现一个函数用来判断字符串str是否表示数值（包括科学计数法的数字，小数和整数）。
     *
     * 科学计数法的数字(按顺序）可以分成以下几个部分:
     * 1.若干空格
     * 2.一个整数或者小数
     * 3.（可选）一个 'e' 或 'E' ，后面跟着一个整数(可正可负)
     * 4.若干空格
     *
     * 小数（按顺序）可以分成以下几个部分：
     * 1.若干空格
     * 2.（可选）一个符号字符（'+' 或 '-'）
     * 3. 可能是以下描述格式之一:
     * 3.1 至少一位数字，后面跟着一个点 '.'
     * 3.2 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 3.3 一个点 '.' ，后面跟着至少一位数字
     * 4.若干空格
     *
     * 整数（按顺序）可以分成以下几个部分：
     * 1.若干空格
     * 2.（可选）一个符号字符（'+' 或 '-')
     * 3. 至少一位数字
     * 4.若干空格
     */

    public boolean isNumeric (String str) {
        // write code here

        char[] chars = str.trim().toCharArray();
        int eIndex = -1;
        boolean isConsE = false;
        boolean isConPoint = false;
        boolean hasNum = false;



        for(int i = 0; i < chars.length ; i++){
           if(chars[i] >= '0' && chars[i] <= '9'){
               hasNum = true;
           }else if(chars[i] == 'e' || chars[i] == 'E'){
               //e之前必须出现过数字
               if(!hasNum) return false;
               //e只能出现一次
               if(isConsE) return false;
               //e之后必须有数字
               if(i == chars.length - 1) return false;
               isConsE = true;
               eIndex = i;
           }else if(chars[i] == '.'){
               //.出现要么后面有数字，要么前面有数字
               if(!hasNum && i == chars.length -1) return false;
               //.只能出现在e的前面
               if(isConsE && i > eIndex) return  false;
               //.点只能出现一次
               if(isConPoint) return false;
               isConPoint = true;
           }else if(chars[i] == '+' || chars[i] == '-'){
               //+-只能出现在第一位或者e的后一位
               if(i != 0 && !isConsE) return false;
               if(isConsE && i!= eIndex + 1) return false;
               //+-不能出现在结尾
               if(i == chars.length - 1) return false;
           }else{
               //只能出现.-+eE数字，其他字符直接返回flase
               return false;
           }
        }
        return hasNum;

    }

    public static void main(String[] args) {
        System.out.println(new Solution18().isNumeric("+1"));
    }


}
