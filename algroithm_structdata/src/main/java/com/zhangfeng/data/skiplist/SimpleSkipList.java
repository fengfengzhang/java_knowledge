package com.zhangfeng.data.skiplist;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @ClassName SimpleSkipList
 * @Description 跳表
 * @Author zhangfeng
 * @Date 2023/3/21 12:50
 */

public class SimpleSkipList {

    private enum Flag{
        HEAD_FLAG,DATA_FLAG,TAIL_FLAG;
    }

    private int height;

    private Node head;

    private Node tail;

    private Random random = new Random(System.currentTimeMillis());

    public SimpleSkipList(){
        head = new Node(Integer.MIN_VALUE,Flag.HEAD_FLAG);
        tail = new Node(Integer.MAX_VALUE,Flag.TAIL_FLAG);
        head.next  = tail;
        tail.pre = head;

    }


    private static class Node{

        public Flag flag;
        public Integer value;
        public Node pre;
        public Node next;
        public Node up;
        public Node down;

        public Node(int value,Flag flag){
            this.value = value;
            this.flag = flag;
        }

        public Node(int value){
            this.value = value;
            this.flag = Flag.DATA_FLAG;
        }
    }

    /**
     * 去跳表中查询这个值或者找到插入位置
     * @param element
     * @return
     */
    public Node findNode(int element){
        Node current = head;
        while(true){
            while(current.next.flag != Flag.TAIL_FLAG &&  current.next.value <= element){
                current = current.next;
            }
            if(current.down == null){
                break;
            }
            current = current.down;
        }
        return current;
    }

    public Node getNode(int element){
        Node node = findNode(element);
        if(node.value != null && node.value == element){
            return node;
        }
        return null;
    }


    public void addNode(int element){
        Node currentNode = findNode(element);

        if (currentNode.value == element){
            return;
        }

        Node newNode = new Node(element);

        newNode.pre = currentNode;
        newNode.next = currentNode.next;
        newNode.next.pre = newNode;
        currentNode.next = newNode;
        int current = 0;
        boolean flag = false;
        while(random.nextInt() < 0.5){
            if(current >= height){
                height ++;
                Node newHead = new Node(Integer.MIN_VALUE,Flag.HEAD_FLAG);
                Node newTail = new Node(Integer.MAX_VALUE,Flag.TAIL_FLAG);

                head.up = newHead;
                newHead.down = head;

                newTail.down = tail;
                tail.up = newTail;

                newHead.next = newTail;
                newTail.pre = newHead;

                head = newHead;
                tail = newTail;
                flag = true;

            }
            while(currentNode.up == null){
                currentNode = currentNode.pre;
            }

            currentNode = currentNode.up;

            Node newUpNode = new Node(element);

            newUpNode.pre = currentNode;
            newUpNode.next = currentNode.next;
            newUpNode.next.pre = newUpNode;
            currentNode.next = newUpNode;

            newNode.up = newUpNode;
            newUpNode.down = newNode;

            newNode = newUpNode;

//            current ++;


           /* if(current + 1 == height){
                return;
            }*/

            if(flag){
                return;
            }
            current ++;

        }


    }


    public void print(){
        Node currentNode = head;
        Node temp = null;
        int h = height + 1;
        while(currentNode != null){
            temp = currentNode.next;
            System.out.printf("%d :", h);
            System.out.print("head_node ->");
            while(temp.flag != Flag.TAIL_FLAG){
                System.out.printf(" %d ->",temp.value);
                temp = temp.next;
            }
            System.out.print("tail_node");
            h --;
            System.out.println();
            currentNode = currentNode.down;
        }
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        SimpleSkipList simpleSkipList = new SimpleSkipList();
        for(int i = 0; i< 200 ;i ++){
            simpleSkipList.addNode(random.nextInt(200));
        }

        simpleSkipList.print();

//        ConcurrentSkipListMap<Integer,Integer> skipListMap = new ConcurrentSkipListMap<>();
    }
}

