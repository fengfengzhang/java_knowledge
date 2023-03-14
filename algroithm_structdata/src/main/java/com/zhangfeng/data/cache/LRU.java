package com.zhangfeng.data.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName LRU
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 17:43
 */
public class LRU {

    Map<Integer,Integer> map;
    LinkedList<Integer>  list;
    int size;
    int capacity;

    public LRU(int capacity) {
        // write code here
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();

    }

    public int get(int key) {
        // write code here
        if(map.containsKey(key)){
            Integer res = map.get(key);
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
            return res;
        }else {
            return  -1;
        }

    }

    public void set(int key, int value) {
        // write code here
        if(map.containsKey(key)){
            map.put(key,value);
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
            return;
        }

        if(size == capacity){
            map.put(key,value);
            Integer last = list.removeLast();
            map.remove(last);
            list.addFirst(key);
        }else{
            size ++;
            map.put(key,value);
            list.addFirst(key);
        }

    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.set(1,1);
        lru.set(2,2);
        lru.set(3,2);
        System.out.println(lru.get(1));
        lru.set(4,4);
        System.out.println(lru.get(2));
    }
}
