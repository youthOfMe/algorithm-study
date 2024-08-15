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

        // System.out.println(getHeadFor(treeNode1));
        // System.out.println(getTailFor(treeNode1));
        System.out.println(getMiddleFor(treeNode1));
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
        Stack<TreeNode> resStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode curTreeNode = stack.pop();
            resStack.push(curTreeNode);
            if (curTreeNode.left != null) {
                stack.push(curTreeNode.left);
            }
            if (curTreeNode.right != null) {
                stack.push(curTreeNode.right);
            }
        }
        while (!resStack.isEmpty()) {
            TreeNode curTreeNode = resStack.pop();
            res.append(curTreeNode.value).append(" ");
        }

        return res.toString();
    }

    public static String getMiddleFor(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curTreeNode = treeNode;
        StringBuilder res = new StringBuilder();
        while (curTreeNode != null) {
            stack.push(curTreeNode);
            curTreeNode = curTreeNode.left;
        }
        while (!stack.isEmpty()) {
            curTreeNode = stack.pop();
            res.append(curTreeNode.value).append(" ");
            curTreeNode = curTreeNode.right;
            if (curTreeNode != null) {
                while (curTreeNode != null) {
                    stack.push(curTreeNode);
                    curTreeNode = curTreeNode.left;
                }
            }
        }
        return res.toString();
    }
}
