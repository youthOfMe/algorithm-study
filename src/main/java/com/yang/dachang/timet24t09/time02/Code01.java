package com.yang.dachang.timet24t09.time02;

import java.util.LinkedList;

/**
 * 层序遍历二叉树
 */
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
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 4;
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 5;
        treeNode2.right = treeNode5;

        System.out.println(getTarget(treeNode1));
    }
    
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int value) {this.value = value;}
    }

    public static String getTarget(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuilder resBuilder = new StringBuilder();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.pop();
            resBuilder.append(curNode.value).append(" ");
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return resBuilder.toString();
    }

}
