package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NC314
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/2 15:41
 */
public class NC314 {

    boolean fCycle = false;

    public boolean canFinish (int numProject, ArrayList<ArrayList<Integer>> groups) {
        // write code here
        List<Integer>[] lists = new List[numProject];

        for(int i = 0; i < numProject ; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < groups.size() ; i++){
            //先完成1才能完成0
            lists[groups.get(i).get(1)].add(groups.get(i).get(0));
        }
        boolean[] visited = new boolean[numProject];
        boolean[] onPath = new boolean[numProject];

        for(int i = 0; i < numProject ; i++){
            process(i,lists,visited,onPath);
        }

        return !fCycle;
    }

    public void process(int k,List<Integer>[] lists, boolean[] visited,boolean[] onPath){
        if(onPath[k]) fCycle = true;
        if(visited[k]) return;
        if(fCycle) return;


        visited[k] = true;
        onPath[k] = true;

        for (Integer i : lists[k]){
            process(i,lists,visited,onPath);
        }

        //所有依赖k的都遍历完成了
        onPath[k] = false;


    }
}
