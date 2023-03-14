package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution44
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 10:50
 */
public class Solution44 {

    /**
     * JZ46
     * 描述
     * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
     *
     * 现在给一串数字，返回有多少种可能的译码结果
     *
     * 数据范围：字符串长度满足 0 < n \le 900<n≤90
     * 进阶：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
     */
    public int solve (String nums) {
        // write code here
        if(nums.startsWith("0")) return 0;
        int[] dp = new int[nums.length()];


        dp[0] = 1;
        for(int i = 1; i < nums.length() ; i++){
            if(nums.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
            if(nums.charAt(i-1) == '1' && (nums.charAt(i) >= '0' && nums.charAt(i) <= '9')
            || (nums.charAt(i-1) == '2')&&((nums.charAt(i) >= '0' && nums.charAt(i) <= '6'))){
                dp[i] += i - 2 >= 0 ? dp[i-2] : 1;
            }else if(nums.charAt(i) == '0' && (nums.charAt(i-1) != '1' || nums.charAt(i-1) != '2') ){
                break;
            }
        }
        return dp[nums.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().solve("21221514217141512522424247182419815122351415423718"));
    }
}
