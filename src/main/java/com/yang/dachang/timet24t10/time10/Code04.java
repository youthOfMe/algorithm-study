package com.yang.dachang.timet24t10.time10;


import com.yang.dachang.timet24t08t08.IndexHeap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * KMP算法第二题
 */
public class Code04 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode();
        a.setValue("3");
        TreeNode b = new TreeNode();
        b.setValue("4");
        TreeNode c = new TreeNode();
        c.setValue("5");
        a.setLeft(b);
        a.setRight(c);
        TreeNode d = new TreeNode();
        d.setValue("1");
        TreeNode e = new TreeNode();
        e.setValue("2");
        b.setLeft(d);
        b.setRight(e);
        TreeNode h = new TreeNode();
        h.setValue("0");
        e.setLeft(h);

        TreeNode treeNode = new TreeNode();
        treeNode.setValue("4");
        TreeNode treeNode2 = new TreeNode();
        treeNode2.setValue("1");
        TreeNode treeNode3 = new TreeNode();
        treeNode3.setValue("2");
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(getTarget(a, treeNode));

        // System.out.println(getTarget(a, c));
    }

    public static boolean getTarget(TreeNode treeNode, TreeNode treeNode2) {
        if (treeNode == null || treeNode2 == null) {
            return false;
        }


        LinkedList<String> treeNodeStr1 = getPreSerializeTarget(treeNode);

        LinkedList<String> treeNodeStr2 = getPreSerializeTarget(treeNode2);

        final int len1 = treeNodeStr1.size();
        final int len2 = treeNodeStr2.size();

        // char[] chars1 = treeNodeStr1.toCharArray();
        // char[] chars2 = treeNodeStr2.toCharArray();
        int[] next = getTarget(treeNodeStr1);
        int x = 0;
        int y = 0;
        while (x < len1 && y < len2) {
            if (Objects.equals(treeNodeStr1.get(x), treeNodeStr2.get(y))) {
                x++;
                y++;
            } else if (next[y] != -1) {
                y = next[y];
            } else {
                x++;
            }
        }

        return y == len2;
    }

    public static int[] getTarget(LinkedList<String> strList) {
        final int N = strList.size();
        final int[] next = new int[N];
        int index = 2;
        int cur = 0;
        next[0] = -1;
        next[1] = 0;
        while (index < N) {
            if (Objects.equals(strList.get(index - 1), strList.get(cur))) {
                next[index++] = ++cur;
            } else if (next[cur] != -1) {
                cur = next[cur];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    public static LinkedList<String> getPreSerializeTarget(TreeNode treeNode) {
        LinkedList<String> linkedList = new LinkedList<>();
        preSerialize(treeNode, linkedList);
        return linkedList;
    }

    public static void preSerialize(TreeNode treeNode, LinkedList<String> linkedList) {
        if (treeNode == null) {
            linkedList.add("#");
        } else {
            linkedList.add(String.valueOf(treeNode.getValue()));
            preSerialize(treeNode.left, linkedList);
            preSerialize(treeNode.right, linkedList);
        }
    }


    private static class TreeNode {
        private String value;
        private TreeNode left;
        private TreeNode right;
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}
