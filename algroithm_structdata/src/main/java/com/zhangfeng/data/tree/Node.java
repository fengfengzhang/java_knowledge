package com.zhangfeng.data.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Node
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 19:10
 */
public class Node {
    int  value;
    Node leftNode;
    Node rightNode;
    public Node(int value) {
        this.value=value;
        leftNode=null;
        rightNode=null;
    }
    public int getValue() {
        return value;
    }
    public Node getLeftNode() {
        return leftNode;
    }
    public Node getRightNode() {
        return rightNode;
    }
    public int height() {
        return Math.max(leftNode==null?0:leftNode.height(),rightNode==null?0:rightNode.height())+1;

    }
    public int leftHeght() {
        if(leftNode==null) {
            return 0;
        }
        return leftNode.height();
    }
    public int rightHeight() {
        if(rightNode==null) {
            return 0;
        }
        return rightNode.height();
    }



    public void add(Node node) {
        if(value>node.getValue()) {
            if(leftNode==null) {
                leftNode=node;
            }else {
                leftNode.add(node);
            }
        }else {
            if(rightNode==null) {
                rightNode=node;
            }else {
                rightNode.add(node);
            }
        }

        if((leftHeght()-rightHeight())>=2) {
            if(leftNode!=null&&(leftNode.leftHeght()<leftNode.rightHeight())) {
                leftNode.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }
        if((leftHeght()-rightHeight())<=-2) {
            if(rightNode!=null&&(rightNode.rightHeight()<rightNode.leftHeght())) {
                rightNode.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
        }

    }
    /**
     * 左旋转
     */

    private void leftRotate() {
        Node node=new Node(value);
        node.leftNode=leftNode;
        node.rightNode=rightNode.leftNode;
        value=rightNode.getValue();
        rightNode=rightNode.rightNode;
        leftNode=node;
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        Node node=new Node(value);
        node.rightNode=rightNode;
        node.leftNode=leftNode.rightNode;
        value=leftNode.getValue();
        leftNode=leftNode.leftNode;
        rightNode=node;


    }
    /*
     *中序遍历
     */
    public void midSearch() {
        if(leftNode!=null) {
            leftNode.midSearch();
        }
        System.out.println(value);
        if(rightNode!=null) {
            rightNode.midSearch();
        }
    }



    /*
     * 查询父亲节点
     */
    public Node searchParent(int value) {
        if((leftNode!=null&&leftNode.getValue()==value)||(rightNode!=null&&rightNode.getValue()==value)) {
            return this;
        }else if(leftNode!=null&&this.value>value) {
            return leftNode.searchParent(value);
        }else if(rightNode!=null&&this.value<value) {
            return rightNode.searchParent(value);
        }
        return null;
    }


    /*
     * 查询节点
     */
    public Node search(int value) {
        if(this.value==value) {
            return this;
        }else if(this.value>value) {
            if(leftNode==null) {
                return null;
            }else {
                return leftNode.search(value);
            }
        }else {
            if(rightNode==null) {
                return null;
            }else {
                return rightNode.search(value);
            }
        }
    }
    /*
     * 层次遍历
     */
    public void leafSearch() {
        Queue<Node> queue=new LinkedList<>();
        System.out.println(value);
        queue.add(this);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.leftNode!=null) {
                System.out.println(node.leftNode.getValue());
                queue.add(node.leftNode);
            }
            if(node.rightNode!=null) {
                System.out.println(node.rightNode.getValue());
                queue.add(node.rightNode);
            }
        }

    }




}
