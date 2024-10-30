package com.yang.dachang.timet24t10.time22;

/**
 * 实现morris先中后序遍历
 */
public class Code01 {

    public static void main(String[] args) {

    }

    /**
     * 二叉树
     */
    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * morris的主要流程必须要牢牢记住
     * 1. 判断当前节点是否有左树
     *      有左树, 就找到左树的最右节点
     *      1.1 最右节点的右指针 -> null, mostRight.right = cur, cur左移
     *      1.2 最右节点的右指针 -> cur, mostRight.eight = null, cur右移动
     * 2. 没有左树
     *      没有左树就直接让cur右移动
     *
     * @param treeNode
     */
    private static void morris(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode cur = treeNode;
        TreeNode mostRight = null;
        // morris会把所有的节点都走一遍 -> 保证所有节点都能遍历到
        while (cur != null) {
            mostRight = cur.left;
            // 有左树
            if (mostRight != null) {
                // 求最右节点 -> 要保障右节点的右节点不是cur(morris遍历特性)
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                // 判断最右节点是否有右节点
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                // 无左树就直接向右移动
                cur = cur.right;
            }
        }
    }

    /**
     * 实现先序遍历
     *
     * @param treeNode
     */
    private static void preMorris(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode cur = treeNode;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println(cur.value);
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    /**
     * 实现中序遍历
     *
     * @param treeNode
     */
    private static void inMorris(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode cur = treeNode;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println(cur.value);
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

}
