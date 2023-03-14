package com.zhangfeng.data.tree;

/**
 * @ClassName AVLTreeTest
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 19:12
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree bst=new AVLTree();
        int[] arr = {3,5,2,7,9,4,0,1};
        for (int j : arr) {
            Node node = new Node(j);
            bst.add(node);
        }
        Node node=new Node(8);
        bst.add(node);
        bst.midSearch();

        System.out.println("===============");
	    Node search = bst.search(5);
	    System.out.println(search.getValue());
	    System.out.println(search.getLeftNode().getValue());
	    System.out.println(search.getRightNode().getValue());
	    System.out.println("=============");
        bst.leafSearch();
        System.out.println("=================");
        System.out.println(bst.searchParent(1).getValue());
	    bst.remove(5);
	    bst.leafSearch();

    }
}
