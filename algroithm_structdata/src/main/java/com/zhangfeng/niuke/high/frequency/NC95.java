package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NC95
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 18:35
 */
public class NC95 {

    /**
     * 给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数
     */

    public int MLS (int[] arr) {
        // write code here
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                continue;
            }
            if (map.containsKey(j - 1)) {
                map.put(j, map.get(j - 1) + 1);
            } else {
                map.put(j, 1);
            }
        }
        int max = 0;
        for(Integer key : map.keySet()){
            max = Math.max(max,map.get(key));
        }

        return max;

    }

    public static void main(String[] args) {
        NC95 nc95 = new NC95();
        System.out.println(nc95.MLS(new int[]{100,4,200,1,3,2}));
    }
}
