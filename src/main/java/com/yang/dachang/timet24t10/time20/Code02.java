package com.yang.dachang.timet24t10.time20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用栈实现递归序
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

        // 先序遍历
        process(treeNode);
    }

    // 二叉树结构
    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 使用栈实现递归序便利
    public static void process(TreeNode treeNode) {
        if (treeNode.left == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(treeNode);
        // 定义上次从栈中弹出的数据
        Integer curStackVal = null;
        // 开始循环
        while (!queue.isEmpty()) {
            // 从队列中弹出数据
            TreeNode curNode = queue.poll();
            System.out.println(curNode.value);
            // 判断是否有左节点
            if (curNode.left != null) {
                // 将自己压入栈中
                stack.push(curNode);
                // 将左变压入队列中
                queue.add(curNode.left);
            } else {
                System.out.println(curNode.value);
            }

            // 判断是否有右节点 -> 没有就再次进行打印
            if (curNode.right == null) {
                System.out.println(curNode.value);
            }

            // 判断上次栈中是否取到数据
            if (curStackVal != null) {
                System.out.println(curStackVal);
            }

            // 判断栈中是否有数据 && 队列中没有数据
            if (!stack.isEmpty() && queue.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.value);
                // 判断是否有右节点, 有就加入到栈中
                if (node.right != null) {
                    queue.add(node.right);
                }
                curStackVal = node.value;
            }
        }

    }

}
