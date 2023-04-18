package com.zhangfeng.data.tree;

import java.util.HashMap;

/**
 * @ClassName TireTree
 * @Description 字典树,(统计词频，判断字符串是否存在，自动补全)
 * @Author zhangfeng
 * @Date 2023/4/18 19:03
 */
public class TireTree {

    private static class TreeNode{
        final static int MAX_SIZE = 26;
        //表示当前节点存的字母
        char data;
        //是不是叶子节点
        boolean isEnd;
        //叶子节点
        TreeNode[] childs;

        //从跟到当前节点的字符串的重复次数
        int frequency;

        //以当前字符串为前缀的字符串数，包括该字符串本身
        int prefixNum;


        private TreeNode(){
            childs = new TreeNode[MAX_SIZE]; //英文26个字母
            isEnd = false;
            frequency = 0;
            prefixNum = 0;
        }

        public TreeNode(char data){
            childs = new TreeNode[MAX_SIZE]; //英文26个字母
            isEnd = false;
            this.data = data;
            frequency = 0;
            prefixNum = 0;
        }


    }

    //树根
    private final TreeNode root;

    public TireTree(){
        this.root = new TreeNode();
    }

    public void insert(String words){
        insert(this.root,words);
    }

    private void insert(TreeNode root,String words){
        char[] chars = words.toCharArray();
        for(int i = 0; i < chars.length ; i++){
            //ascii A=>65,a=>97
            //a->0 ,b->1,c->2   减97
            //转成0-25之间数字，单词全部转成小写
            int index = chars[i] - 'a';
            if(root.childs[index] != null){
                //前缀频次+1
                root.childs[index].prefixNum ++;
            }else{
                root.childs[index] = new TreeNode();
                root.childs[index].prefixNum ++;
            }

            if(i == chars.length -1){
                root.childs[index].isEnd = true;
                root.childs[index].frequency++;
            }
            //root节点指向子节点继续处理
            root = root.childs[index];
        }

    }

    //查询所有单词出现的次数
    public HashMap<String,Integer> getAllWords(){
        return preTraversal(this.root,"");
    }

    private HashMap<String,Integer> preTraversal(TreeNode root,String prefix){
        HashMap<String,Integer> map = new HashMap<>();
        if(root != null){
            if(root.isEnd){
                //当前为一个单词
                map.put(prefix,root.frequency);
            }

            for(int i = 0; i < root.childs.length ; i++){
                if(root.childs[i] != null){
                    char ch = (char) (i+'a');
                    String tempStr = prefix + ch;
                    map.putAll(preTraversal(root.childs[i], tempStr));
                }
            }
        }

        return map;
    }

    //判断字符串是否在字典树中
    public boolean isExist(String word){
       return search(this.root,word);
    }

    private boolean search(TreeNode root, String word) {
        char[] chars = word.toCharArray();
        for(int i = 0; i< chars.length ; i++){
            int index = chars[i] - 'a';

            if(root.childs[index] == null){
                return false;
            }
            root = root.childs[index];
        }

        return root.isEnd;
    }

    //得到以某字符串为前缀的字符串集合，类似自动补全
    public HashMap<String,Integer> getWordForPrefix(String prefix){
       return getWordsForPrefix(this.root,prefix);   
    }

    private HashMap<String, Integer> getWordsForPrefix(TreeNode root, String prefix) {
       HashMap<String,Integer> map = new HashMap<>();
        char[] chars = prefix.toCharArray();
        for(int i = 0; i < chars.length ; i++){
            int index = chars[i] - 'a';
            if(root.childs[index] == null){
                return null;
            }
            root = root.childs[index];
        }

        return preTraversal(root,prefix);
    }

    public static void main(String[] args) {
        TireTree tireTree = new TireTree();
        tireTree.insert("i");
        tireTree.insert("love");
        tireTree.insert("java");
        tireTree.insert("java");
        tireTree.insert("ja");
        tireTree.insert("jav");
        tireTree.insert("tree");
        tireTree.insert("try");
        tireTree.insert("man");
        tireTree.insert("main");
        tireTree.insert("tire");
        HashMap<String, Integer> allWords = tireTree.getAllWords();
        System.out.println(allWords);

        HashMap<String, Integer> prefixMap = tireTree.getWordForPrefix("ja");
        System.out.println(prefixMap);

        System.out.println(tireTree.isExist("ma"));
        System.out.println(tireTree.isExist("main"));


    }


}
