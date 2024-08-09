package com.yang.dachang.timet24t8t07;

/**
 * 前缀树
 */
public class PreTree {

    /**
     * Node
     */
    private static class Node {
        public Node[] nexts = new Node[26];
        public int pass = 0;
        public int end = 0;

        public Node() {
        }
    }

    private Node root;

    public PreTree() {
        root = new Node();
    }

    /**
     * 插入方法
     * @param word
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Node node = root;
        node.pass++;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new Node();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 在
     *
     * @param word
     * @return
     */
    public int search(String word) {
        if (word == null) {
            return 0;
        }

        Node node = root;
        char[] str = word.toCharArray();
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    /**
     * 实现前缀数组搜索
     *
     * @param pre
     * @return
     */
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }

        Node node = root;
        char[] str = pre.toCharArray();
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[i];
        }
        return node.pass;
    }

    /**
     * 删除字符串
     *
     * @param word
     */
    public void delete(String word) {
        if (!(search(word) == 0)) {
            Node node = root;
            char[] str = word.toCharArray();
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
        }
    }

}
