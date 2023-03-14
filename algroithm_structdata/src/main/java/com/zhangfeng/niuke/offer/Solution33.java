package com.zhangfeng.niuke.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Soluion33
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 17:02
 */
public class Solution33 {

    /**
     * JZ35
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）。 下图是一个含有5个结点的复杂链表。图中实线箭头表示next指针，虚线箭头表示random指针。为简单起见，指向null的指针没有画出。
     */

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode point = pHead;
        while (point != null) {
            RandomListNode node = new RandomListNode(point.label);
            map.put(point, node);
            point = point.next;
        }

        point = pHead;
        while (point != null) {
            RandomListNode copyNode = map.get(point);
            copyNode.next = map.get(point.next);
            copyNode.random = map.get(point.random);
            point = point.next;
        }

        return map.get(pHead);

    }


}
