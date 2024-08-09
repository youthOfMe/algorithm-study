package com.yang.dachang.timet24t8t07;

import java.util.HashMap;

public class PreTree2 {

    /**
     * Node
     */
    private static class Node {
        public HashMap<Integer, Node> nexts = new HashMap<>();
        public int pass = 0;
        public int end = 0;

        public Node() {
        }
    }

    private Node root = new Node();

    public PreTree2() {

    }

    /**
     * 插入字符串
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] str = word.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            node.pass++;
            if (!node.nexts.containsKey(path)) {
                node.nexts.put(path, new Node());
            }
            node = node.nexts.get(path);
        }
        node.end++;
    }

    /**
     * 搜索字符串
     *
     * @param word
     * @return
     */
    public int search(String word) {
        if (word == null) {
            return 0;
        }

        char[] str = word.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (!node.nexts.containsKey(path)) {
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.end;
    }

    /**
     * 搜索字符串前缀
     *
     * @param pre
     * @return
     */
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }

        char[] str = pre.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (!node.nexts.containsKey(path)) {
                return 0;
            }
            node = node.nexts.get(path);
        }
        return node.pass;
    }

    public void delete(String word) {
        if (!(search(word) == 0)) {
            char[] str = word.toCharArray();
            Node node = root;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if ((node.nexts.get(path).pass = node.nexts.get(path).pass - 1) == 0) {
                    node.nexts.remove(path);
                    return;
                }
                node = node.nexts.get(path);
            }
        }
    }
}
