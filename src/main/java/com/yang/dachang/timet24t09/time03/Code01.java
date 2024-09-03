package com.yang.dachang.timet24t09.time03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 打印最宽层的二叉树节点数量
 */
public class Code01 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.right = treeNode4;
        // System.out.println(getTarget(treeNode));
        System.out.println(getTargetMore(treeNode));
    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {};

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static int getTarget(TreeNode treeNode) {
        int res = 0;
        int curRes = 0;
        TreeNode end = treeNode;
        TreeNode nextEnd = treeNode;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.pop();
            curRes += 1;
            if (curNode.left != null) {
                queue.add(curNode.left);
                nextEnd = curNode.left;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nextEnd = curNode.right;
            }
            if (curNode == end) {
                end = nextEnd;
                res = Math.max(res, curRes);
                curRes = 0;
            }
        }
        return res;
    }

    /**
     * 使用更多数据结构 -> 开辟一个HashMap
     * 使用HashMap记录每个元素
     *
     * @param treeNode
     * @return
     */
    public static int getTargetMore(TreeNode treeNode) {
        int res = 0;
        int curRes = 0;
        int curLevel = 1;
        Map<TreeNode, Integer> nodeLevelMap = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        nodeLevelMap.put(treeNode, 1);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.pop();
            int curNodeLevel = nodeLevelMap.get(curNode);
            if (curNodeLevel != curLevel) {
                curLevel += 1;
                res = Math.max(res, curRes);
            }
            if (curNode.left != null) {
                nodeLevelMap.put(curNode.left, curLevel + 1);
            }
            if (curNode.right != null) {
                nodeLevelMap.put(curNode.right, curLevel + 1);
            }
            if (curNodeLevel == curLevel) {
                curRes++;
            }
        }
        return res;
    }

}
