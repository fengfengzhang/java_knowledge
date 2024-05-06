package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.List;

public class NC164 {

    /**
     * 给定一个长度为 n 的数组a，求它的最长严格上升子序列的长度。
     * 所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列。
     * 我们定义一个序列是 严格上升 的，当且仅当该序列不存在两个下标
     * 𝑖
     * i 和
     * 𝑗
     * j 满足
     * 𝑖
     * <
     * 𝑗
     * i<j 且
     * 𝑎
     * 𝑖
     * ≥
     * 𝑎
     * 𝑗
     * a
     * i
     * ​
     *  ≥a
     * j
     * ​
     *  。
     * 数据范围：
     * 0
     * ≤
     * 𝑛
     * ≤
     * 1
     * 0
     * 5
     * 0≤n≤10
     * 5
     *  ，
     * −
     * 1
     * 0
     * 9
     * <
     * =
     * 𝑎
     * [
     * 𝑖
     * ]
     * <
     * =
     * 1
     * 0
     * 9
     * −10
     * 9
     *  <=a[i]<=10
     * 9
     *
     * 要求：时间复杂度
     * 𝑂
     * (
     * 𝑛
     * 𝑙
     * 𝑜
     * 𝑔
     * 𝑛
     * )
     * O(nlogn)， 空间复杂度
     * 𝑂
     * (
     * 𝑛
     * )
     * O(n)
     * @param arr
     * @return
     */
    public int LIS (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0){
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        for (int j : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) <= j){
                list.add(j);
            } else {
                int start = 0;
                int end = list.size() - 1 ;
                while (start <= end) {
                    int middle = (end + start) / 2;
                    if (list.get(middle) < j) {
                        start = middle + 1; // 在右半区继续查找
                    } else {
                        end = middle -1; // 在左半区继续查找
                    }

                }


                list.set(start, j);

            }
        }

//        System.out.println(list);
        return list.size();
    }


    public static void main(String[] args) {
        System.out.println(new NC164().LIS(new int[]{10,9,1,5,7,2,3,4}));
    }
}
