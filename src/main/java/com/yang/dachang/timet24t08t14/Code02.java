package com.yang.dachang.timet24t08t14;

import java.util.Stack;

/**
 * 序列化和反序列化二叉树
 */
public class Code02 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 2;
        treeNode1.left = treeNode2;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 3;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 4;
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 5;
        treeNode2.right = treeNode5;

        Stack<String> preSerializeTarget = getPreSerializeTarget(treeNode1);
        System.out.println(preSerializeTarget);
    }

    public static Stack<String> getPreSerializeTarget(TreeNode treeNode) {
        Stack<String> stack = new Stack<>();
        preSerialize(treeNode, stack);
        return stack;
    }

    public static void preSerialize(TreeNode treeNode, Stack<String> stack) {
        if (treeNode == null) {
            stack.push("null");
        } else {
            stack.push(String.valueOf(treeNode.value));
            preSerialize(treeNode.left, stack);
            preSerialize(treeNode.right, stack);
        }
    }
}
