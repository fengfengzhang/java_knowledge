package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;


/**
 * @ClassName NC383
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/15 12:08
 */
public class NC383 {

    /**
     * 有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 starti ,第 i 个活动的结束时间是 endi ,举办某个活动就需要为该活动准备一个活动主持人。
     *
     * 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i 个活动，那么该主持人在 (starti,endi) 这个时间段不能参与其他任何活动。请问一个只有一个主持人能否举办全部活动。
     *
     * 数据范围: 1 \le n \le 10^51≤n≤10
     * 5
     *   ， 0 \le start_i,end_i \le 10^90≤start
     * i
     * ​
     *  ,end
     * i
     * ​
     *  ≤10
     * 9
     */
    public boolean hostschedule (ArrayList<ArrayList<Integer>> schedule) {
        // write code here
        schedule.sort((o1, o2) -> {
            if (o1.get(0) > o2.get(0)) {
                return 1;
            } else if (o1.get(0).equals(o2.get(0))) {
                return o1.get(1) > o2.get(1) ? 1 : -1;
            } else {
                return -1;
            }
        });

        for(int i = 0; i < schedule.size() - 1 ; i++){
            if(schedule.get(i).get(1) >= schedule.get(i+1).get(0)){
                return false;
            }
        }
        return true;
    }
}
