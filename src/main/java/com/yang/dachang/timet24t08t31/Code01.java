package com.yang.dachang.timet24t08t31;

import java.util.ArrayList;
import java.util.List;

/**
 * 完成多叉树 -> 二叉树
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static class MoreTree {
        public int value;
        public List<MoreTree> childNodeList;

        public MoreTree() {

        }

        public MoreTree(int value, List<MoreTree> childNodeList) {
            this.childNodeList = childNodeList;
        }
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
     * 多叉树转二叉树
     * @param moreTree
     * @return
     */
    public static TreeNode moreTreeToTwoTree(MoreTree moreTree) {
        if (moreTree == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(moreTree.value);
        if (moreTree.childNodeList == null || moreTree.childNodeList.isEmpty()) {
            return treeNode;
        }

        treeNode.left = en(moreTree.childNodeList);
        return treeNode;
    }

    public static TreeNode en(List<MoreTree> children) {
        TreeNode head = null;
        TreeNode cur = null;
        for (MoreTree child : children) {
            TreeNode tNode = new TreeNode(child.value);
            if (head == null) {
                head = tNode;
            } else {
                cur.right = tNode;
            }
            cur = tNode;
            cur.left = en(child.childNodeList);
        }
        return cur;
    }

    /**
     * 二叉树 -> 多叉树
     *
     * @param root
     * @return
     */
    public static MoreTree twoTreeToMoreTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        MoreTree result = new MoreTree(root.value, de(root.left));
        return result;
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
