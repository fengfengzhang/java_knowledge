package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Solution43
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 9:56
 */
public class Solution43 {
    /**
     * 描述
     * 输入一个非负整数数组numbers，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组[3，32，321]，则打印出这三个数字能排成的最小数字为321323。
     * 1.输出结果可能非常大，所以你需要返回一个字符串而不是整数
     * 2.拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
     *
     * 数据范围:
     * 0<=len(numbers)<=100
     */

    public String PrintMinNumber(int [] numbers) {


//        List<String> list = Arrays.stream(numbers).boxed().map(String::valueOf).sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1)).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        for(int i : numbers){
            list.add(String.valueOf(i));
        }

        StringBuilder resBuilder = new StringBuilder();
        for (String s : list) {
            resBuilder.append(s);
        }
        return resBuilder.toString();


    }
}
