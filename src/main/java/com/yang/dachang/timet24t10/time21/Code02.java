package com.yang.dachang.timet24t10.time21;

/**
 * morris遍历 -> 前后中序遍历
 */
public class Code02 {

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
     * morris遍历的主流程:
     * 1. 没有左树 -> cur变为自己的右树
     * 2. 有左树
     *      直接去找左树的最右节点
     *      2.1 最右节点的右节点如果为null, 将最右节点的右节点设置为cur节点, 然后让cur向左移动
     *      2.2 最右节点的右节点如果为null, 将最右节点的右节点设置为null, 然后让cur向右移动
     *
     * @param head
     */
    public static void morris(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
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
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morris2(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
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
                   continue;
               } else {
                   mostRight.right = null;
               }
            }
            cur = cur.right;
        }
    }

}
