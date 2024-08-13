package com.yang.dachang.timet24t08t13;

import java.util.Stack;

public class Code01 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 2;
        treeNode1.left = treeNode2;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 3;
        treeNode1.right = treeNode3;

        System.out.println(getHeadFor(treeNode1));
    }

    public static String getHeadFor(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        String res = "";
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res += cur.value + " ";
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public static String getTailFor(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        String res = "";
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res += cur.value + " ";
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
}
