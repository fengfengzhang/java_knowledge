package com.zhangfeng.niuke.offer;

import java.util.ArrayList;

/**
 * @ClassName Solution72
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 11:53
 */
public class Solution72 {
    /**
     * JZ74
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
          ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
          int left = 1;
          int right =2;
          while (left < right){
              if(sum == (left + right)*(right - left + 1)/2){
                  ArrayList<Integer> list = new ArrayList<>();
                  for(int i = left ; i<= right ; i++){
                      list.add(i);
                  }
                  resList.add(list);
                  left ++;
              }else if(sum < (left + right)*(right - left + 1)/2){
                  left ++;
              }else{
                  right ++;
              }
          }

          return resList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution72().FindContinuousSequence(9));
    }


}
