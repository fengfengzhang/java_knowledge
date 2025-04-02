package com.zhangfeng.juejin;


import java.util.*;

/**
 * 小M有
 * n
 * n 张卡牌，每张卡牌的正反面分别写着不同的数字，正面是
 * a
 * i
 * a
 * i
 * ​
 *  ，背面是
 * b
 * i
 * b
 * i
 * ​
 *  。小M希望通过选择每张卡牌的一面，使得所有向上的数字之和可以被3整除。你需要告诉小M，一共有多少种不同的方案可以满足这个条件。由于可能的方案数量过大，结果需要对
 * 1
 * 0
 * 9
 * +
 * 7
 * 10
 * 9
 *  +7 取模。
 *
 * 例如：如果有3张卡牌，正反面数字分别为 (1,2)，(2,3) 和 (3,2)，你需要找到所有满足这3张卡牌正面或背面朝上的数字之和可以被3整除的组合数。
 */
public class Solution33 {

   public static int total;
   public static int solution(int n, int[] a, int[] b) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        total = 0;
        process(0,n,a,b,new ArrayList<Integer>()); // Placeholder return
        return total;
    }


    public static void process(int i, int n, int[] a, int[] b, List<Integer> list){
        //进行一次结算
        if(i == n){
            int sum = 0;

            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < list.size(); k ++){
                sum += list.get(k);
            }

            if ((sum %3) == 0 ){
                total ++;
            }

            total = total %1000000007;


            return;
        }


        list.add(a[i]);
        process(i + 1, n, a, b, list);
        list.remove(list.size() - 1); // 回溯

        // 选择b[i]
        list.add(b[i]);
        process(i + 1, n, a, b, list);
        list.remove(list.size() - 1); // 回溯





    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 2, 3}, new int[]{2, 3, 2}) == 3);
        System.out.println(solution(4, new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 1}) == 6);
        System.out.println(solution(5, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}) == 32);
    }

}
