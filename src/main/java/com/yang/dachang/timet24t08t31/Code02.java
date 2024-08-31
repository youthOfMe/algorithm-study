package com.yang.dachang.timet24t08t31;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树最宽层有几个节点
 */
public class Code02 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.right = treeNode4;
        System.out.println(getTarget(treeNode));
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

    public static int getTarget(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null || root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int result = 1;
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        queue.add(root);
        int curNum = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode != curEnd) {
                curEnd = nextEnd;
                curNum = 0;
            }
            curNum++;
            if (curNode.left != null) {
                queue.add(curNode.left);
                nextEnd = curNode.left;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nextEnd = curNode.right;
            }
            result = Math.max(curNum, result);
        }
        return result;
    }

}
