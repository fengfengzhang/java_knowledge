package com.zhangfeng.leetcode;


/**
 * @ClassName LeetCode208
 * @Description 实现 Trie (前缀树)
 * @Author zhangfeng
 * @Date 2025/8/29 15:50
 */
public class LeetCode208 {

    /**
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
     *
     * 请你实现 Trie 类：
     *
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     */

   static class Trie {

        public TreeNode root;


        public class TreeNode {
            public int MAX_SIZE = 26;

            public TreeNode[] childs;

            public boolean isEnd;

            public char val;


            public TreeNode(){
               this.childs = new TreeNode[MAX_SIZE];
            }


            public TreeNode(char val){
                this.val = val;
                this.childs = new TreeNode[MAX_SIZE];
            }





        }

        public Trie() {
            this.root = new TreeNode();

        }

        public void insert(String word) {
            insert(root,word);
        }


        private void insert(TreeNode root,String word){

            for(int i = 0; i< word.length(); i++){
                char c = word.charAt(i);
                int index = c - 'a';
                if(root.childs[index] == null){
                    root.childs[index] = new TreeNode(c);
                }

                if(i == word.length() - 1){
                    root.childs[index].isEnd = true;
                }

                root = root.childs[index];

            }

        }

        public boolean search(String word) {
            return search(root,word);

        }


        private boolean search(TreeNode root,String word){
            for(int i = 0 ;i <word.length();i++){


                char c = word.charAt(i);
                int index = c - 'a';
                if(root.childs[index] == null){
                    return false;
                }

                root = root.childs[index];
                if(i == word.length() -1 && root.isEnd ){
                    return true;
                }

            }


            return false;
        }

        public boolean startsWith(String prefix) {
            return startsWith(root,prefix);
        }


        private boolean startsWith(TreeNode root,String prefix){

            for(int i = 0; i < prefix.length() ; i++){

                char c = prefix.charAt(i);
                int index = c - 'a';

                if(root.childs[index] == null){
                    return false;
                }

                root = root.childs[index];
            }

            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }

}