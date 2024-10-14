package com.yang.dachang.timet24t10.time10;


import com.yang.dachang.timet24t08t08.IndexHeap;

import java.util.Arrays;
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
        e.setRight(h);
        System.out.println(getTarget(a, b));

        // System.out.println(getTarget(a, c));
    }

    public static boolean getTarget(TreeNode treeNode, TreeNode treeNode2) {
        if (treeNode == null || treeNode2 == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stack.push(treeNode);
        stringBuilder.append(treeNode.getValue());
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }

            if (cur.getLeft() == null) {
                stringBuilder.append("#");
            }
            if (cur.getRight() == null) {
                stringBuilder.append("#");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stack.push(treeNode2);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            stringBuilder2.append(cur.getValue());
            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }
            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
            if (cur.getLeft() == null) {
                stringBuilder2.append("#");
            }
            if (cur.getRight() == null) {
                stringBuilder2.append("#");
            }
        }
        String treeNodeStr1 = stringBuilder.toString();
        String treeNodeStr2 = stringBuilder2.toString();
        System.out.println(treeNodeStr1);
        System.out.println(treeNodeStr2);
        final int len1 = treeNodeStr1.length();
        final int len2 = treeNodeStr2.length();
        char[] chars1 = treeNodeStr1.toCharArray();
        char[] chars2 = treeNodeStr2.toCharArray();
        int[] next = getTarget(chars2);
        int x = 0;
        int y = 0;
        while (x < len1 && y < len2) {
            if (chars1[x] == chars2[y]) {
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

    public static int[] getTarget(char[] chars) {
        final int N = chars.length;
        final int[] next = new int[N];
        int index = 2;
        int cur = 0;
        next[0] = -1;
        next[1] = 0;
        while (index < N) {
            if (chars[index - 1] == chars[cur]) {
                next[index++] = ++cur;
            } else if (next[cur] != -1) {
                cur = next[cur];
            } else {
                next[index++] = -1;
            }
        }
        return next;
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
