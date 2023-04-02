package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName BM56
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/2 12:57
 */
public class BM56 {

    /**
     * 给出一组可能包含重复项的数字，返回该组数字的所有排列。结果以字典序升序排列。
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        process(num,visited,item,list);

        return list;

    }



    public void process(int[] num,boolean[] visited, ArrayList<Integer> item,ArrayList<ArrayList<Integer>> list){
          if(item.size() == num.length){
              list.add(new ArrayList<>(item));
              return;
          }

          for(int i = 0; i < num.length ; i++){
              if(visited[i]) continue;
              if(i>0 && num[i] == num[i-1] && !visited[i-1]) continue;
              visited[i] = true;
              item.add(num[i]);
              process(num,visited,item,list);
              visited[i] =false;
              if (item.size() > 0) item.remove(item.size() -1);

          }
    }



    public static void main(String[] args) {
        BM56 bm56 = new BM56();
        System.out.println(bm56.permuteUnique(new int[]{1, 1, 2}));
    }
}
