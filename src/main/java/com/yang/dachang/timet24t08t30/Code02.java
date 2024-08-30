package com.yang.dachang.timet24t08t30;

/**
 * 实现二叉树的递递归序
 */
public class Code02 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);

        recursionSort(treeNode);
    }

    public static void recursionSort(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.getValue());
        if (treeNode.getLeft() != null) {
            recursionSort(treeNode.getLeft());
            System.out.println(treeNode.getValue());
        } else {
            System.out.println(treeNode.getValue());
        }
        if (treeNode.getRight() != null) {
            recursionSort(treeNode.getRight());
            System.out.println(treeNode.getValue());
        } else {
            System.out.println(treeNode.getValue());
        }
    }

}
