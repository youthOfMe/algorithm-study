package com.yang.dachang.timet24t10.time21;

import com.yang.dachang.timet24t10.time20.Code02;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 使用递归序解决二叉树的先序后序中序遍历 -> 迭代方式
 */
public class Code01 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        // TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        // treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        // 先序遍历
        recursiveTraversal(treeNode);
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
     * 生成二叉树的方法
     * @return
     */
    public static TreeNode createCompleteBinaryTree() {
        // 创建根节点
        TreeNode root = new TreeNode(1);
        // 创建队列用于层序遍历
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int count = 1; // 已创建节点数
        int maxNodes = 15; // 最大节点数

        while (count < maxNodes && !queue.isEmpty()) {
            TreeNode current = queue.poll();
            // 添加左子节点
            if (count < maxNodes) {
                current.left = new TreeNode(count + 1);
                queue.offer(current.left);
                count++;
            }
            // 添加右子节点
            if (count < maxNodes) {
                current.right = new TreeNode(count + 1);
                queue.offer(current.right);
                count++;
            }
        }

        return root;
    }

    public static void recursiveTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // 创建一个队列跑主流程
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 创建一个栈跑副流程
        Stack<TreeNode> stack = new Stack<>();
        // 创建一个值存储进入栈中的数据的值
        Integer inStackValue = null;

        // 主流程前置操作
        queue.add(root);

        // 开始主流程
        while (!queue.isEmpty()) {
            // 1. 从队列中弹出数据 并打印数据
            TreeNode cur = queue.poll();
            System.out.println(cur.value);
            // 2. 判断是否有左节点
            if (cur.left != null) {
                // 2.1 将左节点存入队列中
                queue.add(cur.left);
                // 2.2 将自己存放到栈中
                stack.push(cur);
            } else {
                // 2.3 如果没有就继续打印当前数据
                System.out.println(cur.value);
            }

            // 3. 判断是否没有左右节点 -> 没有就再次打印
            if (cur.right == null && cur.left == null) {
                System.out.println(cur.value);
            }

            // 开始副流程
            // 4. 判断上次循环是否从队列中弹出数据
            if (inStackValue != null) {
                System.out.println(inStackValue);
            }

            // 5. 判断栈中是否有数据
            while (!stack.isEmpty() && queue.isEmpty()) {
                // 5.1 从栈中弹出数据，并打印
                TreeNode node = stack.pop();
                System.out.println(node.value);
                // 5.2 判断弹出的数据是否有右节点
                if (node.right != null) {
                    queue.add(node.right);
                    // 为弹出的栈值进行赋值, 方便下次进行弹出数据
                    inStackValue = node.value;
                } else {
                    // 如果没有右节点就回来打印
                    System.out.println(node.value);
                }
            }
        }
    }


}
