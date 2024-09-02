package com.yang.dachang.timet24t09.time02;

/**
 * 找节点的后继节点
 * 后继节点 -> 中序遍历后面的一个节点
 */
public class Code04 {

    public static void main(String[] args) {

    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }

    public static Integer getTarget(TreeNode treeNode) {
        if (treeNode.right != null) {
            TreeNode curNode = treeNode.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode.value;
        } else {
            TreeNode curNode = treeNode;
            while (curNode.parent != null) {
                if (curNode.parent.left == curNode) {
                    return curNode.parent.left.value;
                }
            }
            return null;
        }
    }

}
