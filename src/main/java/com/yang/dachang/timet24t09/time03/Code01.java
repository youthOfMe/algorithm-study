package com.yang.dachang.timet24t09.time03;

import java.util.LinkedList;

/**
 * 打印最宽层的二叉树节点数量
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }

    public static int getTarget(TreeNode treeNode) {
        int res = 0;
        int curRes = 0;
        TreeNode end = treeNode;
        TreeNode nextEnd = treeNode;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.pop();
            curRes += 1;
            if (curNode.left != null) {
                queue.add(curNode.left);
                nextEnd = curNode.left;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nextEnd = curNode.right;
            }
            if (curNode == end) {
                end = nextEnd;
                res = Math.max(res, curRes);
            }
        }
        return res;
    }

}
