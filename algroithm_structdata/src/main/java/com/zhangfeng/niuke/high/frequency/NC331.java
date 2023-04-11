package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC331
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 19:45
 */
public class NC331 {
    /**
     * 给定一个字符串，请你判断这个字符串是否可以通过重复多次它的子字符串来构成。
     */
    public boolean repeatSubstring (String str) {
        // write code here

        String temStr = str + str;
        temStr = temStr.substring(1);
        return  temStr.indexOf(str) != str.length() -1;
    }

    public static void main(String[] args) {
        NC331 nc331 = new NC331();
        System.out.println(nc331.repeatSubstring("wlrbbmqb"));
    }
}
