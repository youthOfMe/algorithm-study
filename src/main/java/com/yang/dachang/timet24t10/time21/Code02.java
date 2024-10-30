package com.yang.dachang.timet24t10.time21;

/**
 * morris遍历 -> 前后中序遍历
 */
public class Code02 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        preMorris(treeNode);
        System.out.println("=== 中序遍历 ===");
        inMorris(treeNode);
        System.out.println("=== 后序遍历 ===");
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

    /**
     * 使用morris序实现先序遍历
     *
     * @param head
     */
    public static void preMorris(TreeNode head) {
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
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    /**
     * 使用morris遍历实现中序遍历
     *
     * @param head
     */
    public static void inMorris(TreeNode head) {
        if (head == null) return;;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // 有左树
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                // 若为空则为第一次来到它自己, 不为空则第二次来到自己
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    System.out.println(cur.value);
                    mostRight.right = null;
                }
            } else {
                // 没有左树
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

}
