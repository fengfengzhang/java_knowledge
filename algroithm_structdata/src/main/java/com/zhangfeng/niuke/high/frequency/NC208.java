package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName NC208
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/24 20:50
 */
public class NC208 {
    /**
     * 根据往后 n 天的天气预报，计算每一天需要等待几天才会出现一次更高的气温，如果往后都没有更高的气温，则用 0 补位。
     *
     * 例如往后三天的气温是 [1,2,3] ， 则输出 [1,1,0]
     */

    //单调栈求数组每个数离我最近比我大或者比我小
    public int[] temperatures (int[] dailyTemperatures) {
        // write code here
        if(dailyTemperatures == null || dailyTemperatures.length == 0){
            return null;
        }
        int[] res = new int[dailyTemperatures.length];
        Stack<Integer> stack = new Stack<>();
        int k;
        for(int i= 0; i < dailyTemperatures.length ; i++){
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && dailyTemperatures[stack.peek()] < dailyTemperatures[i]) {
                    k = stack.peek();
                    res[stack.pop()] = i - k;
                }

            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            res[stack.pop()] = 0;
        }

      return res;
    }

    public static void main(String[] args) {
        NC208 nc208 = new NC208();
        System.out.println(Arrays.toString(nc208.temperatures(new int[]{52, 79, 74, 30, 41, 73, 30,84,98,100})));
    }
}
