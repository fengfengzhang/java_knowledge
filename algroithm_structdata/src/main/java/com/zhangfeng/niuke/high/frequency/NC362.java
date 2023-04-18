package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;

/**
 * @ClassName NC362
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/18 21:33
 */
public class NC362 {
    /**
     * 给定一个正整数，按字典序返回 [1,n] 内的正整数。
     */

    public ArrayList<Integer> orderArray (int n) {
        // write code here

        ArrayList<Integer> list = new ArrayList<>();
        dfs(list,n,0,1);
        return list;
    }


    public void dfs(ArrayList<Integer> list , int n,int base,int start){
        if(base > n) return;

        for(int i = start ;i < 10 ;i++){
            int next = base + i;
            if(next <= n){
                list.add(next);
                dfs(list,n,next * 10,0);
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        NC362 nc362 = new NC362();
        System.out.println(nc362.orderArray(10));
    }

}
