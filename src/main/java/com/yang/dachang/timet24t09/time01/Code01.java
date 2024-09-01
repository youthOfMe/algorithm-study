package com.yang.dachang.timet24t09.time01;

/**
 * 递归遍历二叉树
 */
public class Code01 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        // 1. 测试先序遍历二叉树

        getTree(treeNode);
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
     * 递归遍历二叉树
     *
     * @param root
     */
    public static void getTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // preGetProcess(root);
        // middleGetProcess(root);
        endGetProcess(root);
    }

    public static void preGetProcess(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preGetProcess(root.left);
        preGetProcess(root.right);
    }

    public static void middleGetProcess(TreeNode node) {
        if (node == null) {
            return;
        }
        middleGetProcess(node.left);
        System.out.println(node.value);
        middleGetProcess(node.right);
    }

    public static void endGetProcess(TreeNode node) {
        if (node == null) {
            return;
        }
        middleGetProcess(node.left);
        middleGetProcess(node.right);
        System.out.println(node.value);
    }
}
