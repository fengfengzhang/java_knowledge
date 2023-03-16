package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ClassName NC37
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/16 13:44
 */
public class NC37 {

    /**
     * 给出一组区间，请合并所有重叠的区间。
     * 请保证合并后的区间按区间起点升序排列。
     */

    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.isEmpty()) return intervals;

        Comparator<Interval> comparator = (o1, o2) -> {
            if (o1.start > o2.start) {
                return 1;
            } else if (o1.start == o2.start) {
                return o1.end > o2.end ? 1 : -1;
            } else {
                return -1;
            }};

        intervals.sort(comparator);

        ArrayList<Interval> list = new ArrayList<>();
        Interval item = intervals.get(0);
        for(int i = 1; i < intervals.size() ; i++){

            if(item.start <= intervals.get(i).start
                    && item.end >= intervals.get(i).start){
                item.end = Math.max(intervals.get(i).end,item.end);
            }else{
                list.add(item);
                item = intervals.get(i);
            }
        }

        list.add(item);

        return list;

    }



}
