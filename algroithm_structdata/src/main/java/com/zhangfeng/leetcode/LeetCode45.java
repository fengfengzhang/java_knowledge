package com.zhangfeng.leetcode;

import java.util.Arrays;

public class LeetCode45 {
    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     */
    public int jump(int[] nums) {
      if(nums == null || nums.length == 0){
          return 0;
      }

      int[] dp = new int[nums.length];
      Arrays.fill(dp,Integer.MAX_VALUE);
      dp[0] = 0;
      for(int i = 1; i < nums.length ; i++){
          for(int j = 0 ;j < i ; j++){
             if(nums[j] + j >= i){
                 dp[i] = Math.min(dp[i],dp[j] + 1);
             }
          }
      }

      return dp[nums.length - 1];

    }


    /**
     * 贪心解法
     * 记录没个位置能跳到最远多远，能跳到位置继续在看能跳到多远，每跳一次，次数加1
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int end = 0;
        int start = 0;
        int res = 0;
        int maxPos = 0;
        while (maxPos < nums.length - 1){

            for(int i = start ; i <= end ; i++){
                //当前这一跳最远能跳多远
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            res ++;
            //这一跳中间从哪里跳过去不关心，最远已经到了那个位置，此时只关心下一跳
            start = end + 1;

            end = maxPos;

        }

        return  res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode45().jump2(new int[]{1,1,2,1,1}));
    }
}
