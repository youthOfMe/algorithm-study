package com.yang.dachang.timet24t10.time20;

/**
 * 手写递归遍历二叉树
 */
public class Code01 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        // 先序遍历
        preProcess(treeNode);

    }

    // 二叉树结构
    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void preProcess(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.value);
        preProcess(treeNode.left);
        preProcess(treeNode.right);
    }

}
