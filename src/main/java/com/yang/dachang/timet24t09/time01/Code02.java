package com.yang.dachang.timet24t09.time01;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 非递归遍历二叉树
 */
public class Code02 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        // endGetTree(treeNode);
        // middleGetTree(treeNode);
        preGetTree(treeNode);
    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param node
     */
    public static void endGetTree(TreeNode node) {
        Stack<TreeNode> forceStack = new Stack<>();
        Stack<TreeNode> prinStack = new Stack<>();
        forceStack.push(node);
        while (!forceStack.isEmpty()) {
            TreeNode curNode = forceStack.pop();
            prinStack.push(curNode);
            if (curNode.left != null) {
                forceStack.push(curNode.left);
            }
            if (curNode.right != null) {
                forceStack.push(curNode.right);
            }
        }
        while (!prinStack.isEmpty()) {
            TreeNode curNode = prinStack.pop();
            System.out.println(curNode.value);
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param node
     */
    public static void middleGetTree(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (node.left != null) {
            stack.push(node.left);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            System.out.println(curNode.value);
            if (curNode.right != null) {
                curNode = curNode.right;
                stack.push(curNode);
                while (curNode.left != null) {
                    stack.push(curNode.left);
                    curNode = curNode.left;
                }
            }
        }
    }

    /**
     * 完成二叉树迭代后续遍历
     *
     * @param node
     */
    public static void preGetTree(TreeNode node) {
        Stack<TreeNode> forceStack = new Stack<>();
        LinkedList<TreeNode> printQueue = new LinkedList<>();
        forceStack.push(node);
        while (!forceStack.isEmpty()) {
            TreeNode curNode = forceStack.pop();
            printQueue.add(curNode);
            if (curNode.right != null) {
                forceStack.push(curNode.right);
            }
            if (curNode.left != null) {
                forceStack.push(curNode.left);
            }
        }
        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.removeFirst().value);
        }
    }
}
