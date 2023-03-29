package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName BM89
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/29 14:21
 */
public class BM89 {

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

        Comparator<Interval> comparator = (o1,o2) ->{
            if(o1.start < o2.start){
                return -1;
            }else if(o1.start > o2.start){
                return  1;
            }else{
                return o1.end < o2.end ? -1 : 1;
            }
        };

        Collections.sort(intervals,comparator);
        ArrayList<Interval> list = new ArrayList<>();
        for(int i = 0; i  < intervals.size() ; i++){
            if(list.size() == 0){
                list.add(intervals.get(i));
            }else{
                Interval interval = list.get(list.size() - 1);

                if(interval.end >= intervals.get(i).start){
                    interval.end = Math.max(intervals.get(i).end,interval.end);

                }else{
                    list.add(intervals.get(i));
                }
            }
        }

        return list;
    }



}
