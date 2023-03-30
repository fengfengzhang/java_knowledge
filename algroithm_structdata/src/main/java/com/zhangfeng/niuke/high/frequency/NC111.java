package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName NC111
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/30 18:50
 */
public class NC111 {
    /**
     * 给定一个长度为n的数组nums，数组由一些非负整数组成，现需要将他们进行排列并拼接，每个数不可拆分，使得最后的结果最大，返回值需要是string类型，否则可能会溢出。
     */

    public String solve (int[] nums) {
        // write code here
//        List<String> list = Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        for(int a : nums){
            list.add(String.valueOf(a));
        }

        Comparator<String> comparator = (s1,s2)-> (s2 + s1).compareTo(s1+s2);
        list.sort(comparator);

        StringBuilder resBuilder = new StringBuilder();
        for (String s : list) {
            resBuilder.append(s);
        }

        String res = resBuilder.toString();
        return  res.startsWith("0") ? "0" : res;
    }

    public static void main(String[] args) {
        NC111 nc111 = new NC111();
        System.out.println(nc111.solve(new int[]{2,20,23,4,8}));
    }


}
