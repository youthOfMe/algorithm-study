package com.yang.dachang.timet24t09.time02;

import java.util.ArrayList;
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
        public MoreTree(int value, List<MoreTree> moreTreeList) {
            this.value = value;
            this.moreTreeList = moreTreeList;
        }
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

    /**
     * 多叉树 -> 二叉树
     * @param treeNode
     * @return
     */
    public static MoreTree twoTreeToMoreTree(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        MoreTree moreTree = new MoreTree(treeNode.value);
        if (treeNode.left == null || treeNode.right == null) {
            return moreTree;
        }

        MoreTree res = new MoreTree(treeNode.value, de(treeNode.left));
        return res;
    }

    public static List<MoreTree> de(TreeNode root) {
        List<MoreTree> children = new ArrayList<>();
        while (root != null) {
            MoreTree tNode = new MoreTree(root.value, de(root.left));
            children.add(tNode);
            root = root.right;
        }
        return children;
    }

}
