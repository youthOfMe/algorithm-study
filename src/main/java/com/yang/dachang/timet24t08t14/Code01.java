package com.yang.dachang.timet24t08t14;


import java.util.LinkedList;

/**
 * 二叉树的层序遍历
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

        System.out.println(getTarget(treeNode1));;
    }

    public static String getTarget(TreeNode treeNode) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.append(node.value).append(" ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return res.toString();
    }
}
