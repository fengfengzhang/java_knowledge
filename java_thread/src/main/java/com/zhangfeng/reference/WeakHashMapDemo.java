package com.zhangfeng.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @ClassName WeakHashMapDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 20:55
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
//        myHashMap();
        myWeakHashMap();
    }

    //发生gc就会被清空
    private static void myWeakHashMap() {

        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value ="my WeakHashMap";
        map.put(key,value);

        System.out.println(map.get(2));
        key = null;
        System.out.println(map.get(2));
        System.gc();
        System.out.println(map.get(2));
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = 1;
        String value ="my HashMap";
        map.put(key,value);
        key = null;
        System.gc();
        System.out.println(map.get(1));
    }
}
