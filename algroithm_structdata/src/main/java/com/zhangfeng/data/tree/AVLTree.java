package com.zhangfeng.data.tree;

/**
 * @ClassName AVLTree
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 19:10
 */
public class AVLTree {
    Node rootNode;

    public Node getNode() {
        return rootNode;
    }

    /**
     * 添加节点
     * @param node
     */
    public void  add(Node node) {
        if(rootNode==null) {
            rootNode=node;
        }else {
            rootNode.add(node);
        }
    }
    /*
     * 中序遍历
     */
    public void midSearch() {
        if(rootNode==null) {
            return;
        }
        rootNode.midSearch();
    }
    /*
     * 层次遍历
     */
    public void leafSearch() {
        if(rootNode==null) {
            return;
        }
        rootNode.leafSearch();
    }
    /*
     *查找某一节点
     */
    public Node search(int value) {
        if(rootNode==null) {
            return null;
        }
        return  rootNode.search(value);
    }

    /*
     * 删除节点
     */
    public void remove(int value) {
        if(rootNode==null) {
            return ;
        }
        Node target=search(value);
        if(target==null) {
            return;
        }else {
            if(target.leftNode==null&&target.rightNode==null) {
                Node parent=searchParent(value);
                if(parent.leftNode==target) {
                    parent.leftNode=null;
                }else {
                    parent.rightNode=null;
                }
            }else if(target.leftNode!=null&&target.rightNode!=null) {
                int min = Minsearch(target.rightNode);
                target.value = min;
            }else {
                Node parent=searchParent(value);
                if(target.leftNode!=null) {
                    if(parent.leftNode==target) {
                        parent.leftNode=target.leftNode;
                    }else {
                        parent.rightNode=target.leftNode;
                    }
                }else {
                    if(parent.leftNode==target) {
                        parent.leftNode=target.rightNode;
                    }else {
                        parent.rightNode=target.rightNode;
                    }
                }
            }
        }


    }
    /*
     * 查找最小值ֵ
     */
    public int Minsearch(Node target) {
        Node node=target;
        while(node.leftNode!=null) {
            node=node.leftNode;
        }
        int result=node.getValue();
        remove(result);
        return result;

    }

    /**
     * 查询父亲节点
     * @param value
     * @return node
     */
    public Node searchParent(int value) {
        if(rootNode==null) {
            return null;
        }
        return  rootNode.searchParent(value);
    }
}

