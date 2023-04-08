package com.zhangfeng.niuke.high.frequency;

import java.util.*;

/**
 * @ClassName NC94
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/8 13:47
 */
public class NC94 {
    /**
     * 一个缓存结构需要实现如下功能。
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；
     * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
     * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
     */
    public static class Node{
        int key;
        int value;
        int times;
        public Node(int key,int value,int times){
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }


    public static class LFU{
        public Map<Integer,Node> map;
        public Map<Integer, LinkedList<Node>> timesMap;
        int capacity;
        int size;
        int min;

        public LFU(int capacity){
            this.capacity = capacity;
            map = new HashMap<>();
            timesMap = new HashMap<>();
        }

        public int get(int key){
            if(!map.containsKey(key)){
                return  -1;
            }
            return getNode(key).value;
        }

        public void set(int key,int value){
            if(map.containsKey(key)){
                Node node = getNode(key);
                node.value = value;
            }else{
                Node node = new Node(key, value, 1);
                map.put(key,node);
                if(timesMap.containsKey(1)){
                    timesMap.get(1).addFirst(node);
                }else{
                    LinkedList<Node> newNodes = new LinkedList<>();
                    newNodes.addFirst(node);
                    timesMap.put(node.times, newNodes);
                }
                if(size < capacity){
                    size ++;

                }else{
                    Node removeNode = timesMap.get(min).removeLast();
                    map.remove(removeNode.key);
                }

                min = 1;
            }
        }


        private Node getNode(int key){
            Node node = map.get(key);
            LinkedList<Node> nodes = timesMap.get(node.times);
            nodes.remove(node);
            if(node.times == min && nodes.size() == 0){
                min ++;
            }
            node.times ++;
            if(timesMap.containsKey(node.times)){
               timesMap.get(node.times).addFirst(node);
            }else{
                LinkedList<Node> newNodes = new LinkedList<>();
                newNodes.addFirst(node);
                timesMap.put(node.times, newNodes);
            }

            return node;

        }

    }




    public int[] LFU (int[][] operators, int k) {
        // write code here
        List<Integer> list = new ArrayList<>();
        LFU lfu = new LFU(k);
        for(int i = 0; i < operators.length ; i++){
            int op = operators[i][0];
            switch (op){
                case 1 : lfu.set(operators[i][1],operators[i][2]);
                break;
                case 2 : list.add(lfu.get(operators[i][1]));
                break;
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
