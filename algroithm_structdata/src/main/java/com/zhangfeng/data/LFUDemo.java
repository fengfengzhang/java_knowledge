package com.zhangfeng.data;

import java.util.*;

/**
 * @ClassName LFU
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 18:05
 */
public class LFUDemo {

    /**
     * 一个缓存结构需要实现如下功能。
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；
     * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
     * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
     *
     * 数据范围：0 < k \le 10^50<k≤10
     * 5
     *  ，|val| \le 2 \times 10^9∣val∣≤2×10
     * 9
     *
     * 要求：get和set的时间复杂度都是 O(logn)O(logn)，空间复杂度是 O(n)O(n)
     *
     *
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     *
     * 对于每个操作2，返回一个答案
     */

    private static class Node{
        int key;
        int value;
        int freq;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

    private static class LFU{
        Map<Integer,Node> map;
        Map<Integer, LinkedList<Node>> freqMap;
        int min;
        int size;
        int capacity;

        public LFU(int capacity){
            this.capacity = capacity;
            map = new HashMap<>();
            freqMap = new HashMap<>();
        }

        private Node getNode(int key){
            Node node = map.get(key);
            LinkedList<Node> nodes = freqMap.get(node.freq);
            nodes.remove(node);
            if(nodes.size() == 0) freqMap.remove(node.freq);

            if(min == node.freq && nodes.size() == 0){
                min ++;
            }

            node.freq ++;

            LinkedList<Node> newNodes = freqMap.get(node.freq) != null ? freqMap.get(node.freq) : new LinkedList<>();
            newNodes.addFirst(node);
            freqMap.put(node.freq,newNodes);
            return node;
        }

        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }

            Node  node = getNode(key);
            return node.value;
        }


        public void set(int key , int value){
            if(map.containsKey(key)){
                Node node = getNode(key);
                node.value = value;
                return;
            }
            Node node = new Node(key,value);
            map.put(key,node);
            LinkedList<Node> newNodes = freqMap.get(node.freq) != null ? freqMap.get(node.freq) : new LinkedList<>();
            newNodes.addFirst(node);
            freqMap.put(node.freq,newNodes);

            if(size == capacity){
                LinkedList<Node> removeLinkedList = freqMap.get(min);
                Node removeNoe = removeLinkedList.removeLast();
                map.remove(removeNoe.key);
                if(removeLinkedList.size() == 0) freqMap.remove(min);

            }else{
                size ++;

            }
            this.min = 1;
        }
    }

    /**
     * lfu design
     * @param operators int整型二维数组 ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LFU (int[][] operators, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        // write code here
        LFU lfu = new LFU(k);
        for(int i = 0; i < operators.length ; i++){
            int op = operators[i][0];
            switch (op){
                case 1:
                    lfu.set(operators[i][1],operators[i][2]);
                    break;
                case 2:
                    list.add(lfu.get(operators[i][1]));
                    break;
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length ; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        LFUDemo lfuDemo1 = new LFUDemo();
        System.out.println(Arrays.toString(lfuDemo1.LFU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {1, 2, 4}, {1, 3, 5}, {2, 2}, {1, 4, 4}, {2, 1}}, 3)));

    }
}
