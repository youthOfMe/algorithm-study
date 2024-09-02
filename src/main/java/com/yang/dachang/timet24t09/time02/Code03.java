package com.yang.dachang.timet24t09.time02;

import java.util.List;

/**
 * 多叉树 -> 二叉树
 */
public class Code03 {

    public static void main(String[] args) {

    }

    // 多叉树结构
    public static class MoreTree {
        public int value;
        public List<MoreTree> moreTreeList;

        public MoreTree() {};
        public MoreTree(int value) {this.value = value;}
    }

    // 二叉树结构
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {};
        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 多叉树 -> 二叉树
     *
     * @param moreTree
     * @return
     */
    public static TreeNode moreTreeToTwoTree(MoreTree moreTree) {
        if (moreTree == null) return null;

        TreeNode treeNode = new TreeNode(moreTree.value);
        if (moreTree.moreTreeList == null || moreTree.moreTreeList.isEmpty()) {
            return treeNode;
        }

        treeNode.left = en(moreTree.moreTreeList);
        return treeNode;
    }

    public static TreeNode en(List<MoreTree> moreTreeList) {
        TreeNode head = null;
        TreeNode cur = null;

        for (MoreTree moreTree : moreTreeList) {
            TreeNode curTreeNode = new TreeNode(moreTree.value);
            if (head == null) {
                head = curTreeNode;
            } else {
                cur.right = curTreeNode;
            }
            cur = curTreeNode;
            cur.left = en(moreTree.moreTreeList);
        }

        return head;
    }

}
