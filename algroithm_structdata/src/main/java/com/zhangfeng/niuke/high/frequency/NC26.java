package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NC26
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/24 20:26
 */
public class NC26 {

    /**
     * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
     * 例如，给出n=3，解集为：
     */
    public ArrayList<String> generateParenthesis (int n) {
        // write code here

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        process(list,sb,0,0,n);
        return list;
    }


    //先放左边大于右边，就放右边
    public void process(ArrayList<String> list,StringBuilder sb,int left,int right,int n){
        if(sb.length() == 2*n){
            String str = sb.toString();
            list.add(str);

        }

        if(left < n){
            sb.append("(");
            process(list,sb,left+1,right,n);
        }

        if(left > right) {
            sb.append(")");
            process(list, sb, left, right + 1, n);
        }

        if(sb.length() > 0){
            sb.deleteCharAt(sb.length() -1);
        }


    }

    public static void main(String[] args) {
        NC26 nc26 = new NC26();
        System.out.println(nc26.generateParenthesis(2));
    }

}
