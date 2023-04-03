package com.zhangfeng.algroithm.loadBalancing;


import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName ConsistentHash
 * @Description 哈希环负载均衡
 * @Author zhangfeng
 * @Date 2023/4/3 15:02
 */
public class ConsistentHash {

    //用红黑树有序
    private static TreeMap<Integer,String> virtualNodes = new TreeMap<>();
    private static final int VIRTUAL_NODES = 160;

    //初始化hash环
    static {
        //对每个真实节点添加虚拟节点，虚拟节点会根据hash算法进行散列
        for(String ip : ServerIps.List){
            for(int i = 0; i < VIRTUAL_NODES ; i++){
                int hash = getHash(ip + "VN" + i);
                virtualNodes.put(hash,ip);
            }
        }

    }


    /**
     * TreeMap = 数组 + 红黑树
     * 客服端hash落在哪个区间，找大于等于此hash值对应的node的IP
     *
     */

    public static String getServer(String ClientInfo){
        //客户端对应的hash值
        int hash = getHash(ClientInfo);
        //找刚好大于等于此hash值的Node,
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);

        //获取该树的第一个元素，也就是最小元素
        Integer nodeKey = subMap.firstKey();
        //如果没有大于该元素的子数，则取整棵树的第一个元素，相当于hash环中的最小值
        if(nodeKey == null){
            nodeKey = virtualNodes.firstKey();
        }

        //返回对应虚拟节点名称
        return virtualNodes.get(nodeKey);
    }


    //随便一个hash算法
    private static int getHash(String str){
        final  int p = 1677619;
        int hash = (int)2166136261L;
        for(int i = 0; i < str.length() ; i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        //如果是负数就取绝对值
        if(hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 50 ; i++){
            System.out.println(getServer(i + "server"));
        }

    }



}
