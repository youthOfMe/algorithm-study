package com.yang.dachang.timet24t08t14;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 序列化和反序列化二叉树
 */
public class Code02 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 2;
        treeNode1.left = treeNode2;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 3;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 4;
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 5;
        treeNode2.right = treeNode5;

        LinkedList<String> preSerializeTarget = getPreSerializeTarget(treeNode1);
        System.out.println(preSerializeTarget);

        System.out.println(getHeadFor(getPreOppositeSerializeTarget(preSerializeTarget)));
        // getHeadFor();

        System.out.println(getLayerSerializeTarget(treeNode1));
    }

    // 先序序列化二叉树
    public static LinkedList<String> getPreSerializeTarget(TreeNode treeNode) {
        LinkedList<String> stack = new LinkedList<>();
        preSerialize(treeNode, stack);
        return stack;
    }

    public static void preSerialize(TreeNode treeNode, LinkedList<String> stack) {
        if (treeNode == null) {
            stack.add("null");
        } else {
            stack.add(String.valueOf(treeNode.value));
            preSerialize(treeNode.left, stack);
            preSerialize(treeNode.right, stack);
        }
    }

    // 先序反序列化二叉树
    public static TreeNode getPreOppositeSerializeTarget(LinkedList<String> stack) {
        return preOppositeSerialize(stack);
    }

    public static TreeNode preOppositeSerialize(LinkedList<String> stack) {
        String treeNodeStr = stack.poll();
        if (treeNodeStr.equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.value = Integer.valueOf(treeNodeStr);
        treeNode.left = preOppositeSerialize(stack);
        treeNode.right = preOppositeSerialize(stack);
        return treeNode;
    }

    public static String getHeadFor(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        String res = "";
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res += cur.value + " ";
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public static LinkedList<String> getLayerSerializeTarget(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<String> resQueue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            resQueue.add(String.valueOf(treeNode.value));
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            } else {
                resQueue.add("null");
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            } else {
                resQueue.add("null");
            }

        }
        return resQueue;
    }

}
