package com.yang.dachang.timet24t08t17;

import java.util.*;

/**
 * 贪心算法解决金条分配问题
 */
public class Code02 {

    public static void main(String[] args) {
        GoldBar goldBar = new GoldBar(60);
        int[] resArr = new int[]{10, 20, 30};
        int result = getResult(goldBar, resArr);
        System.out.println(result);
        System.out.println(Arrays.toString(getTarget(goldBar, resArr)));
    }

    public static class GoldBar {
        int length;

        public GoldBar(int length) {
            this.length = length;
        }
    }

    // 暴力解决
    public static int getResult(GoldBar goldBar, int[] resArr) {
        if (goldBar == null || goldBar.length <= 0) {
            return 0;
        }
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        // 算出切第一个的最小值
        int minCost = 0;
        GoldBar curGoldBar = new GoldBar(goldBar.length);
        for (int i = 0; i < resArr.length - 1; i++) {
            minCost += curGoldBar.length;
            curGoldBar = new GoldBar(curGoldBar.length - resArr[i]);
        }
        int res = process(goldBar, resArr, minCost, 0, resList);
        // System.out.println(Arrays.toString(resList.toArray()));
        return res;
    }

    public static int process(GoldBar goldBar, int[] resArr, int cost, int preCost, ArrayList<ArrayList<Integer>> resList) {
        if (resArr.length < 2) {
            return preCost;
        }

        int minCost = cost;
        for (int i = 0; i < resArr.length; i++) {
            int curGoldLen = resArr[i];
            int[] nextResArr = removeiGetArr(resArr, i);
            GoldBar nextGold = new GoldBar(goldBar.length - curGoldLen);
            // if (resList.size() < (i + 1)) {
            //     resList.add(new ArrayList<>());
            //     resList.get(i).add(goldBar.length);
            // } else {
            //     resList.get(i).add(goldBar.length);
            // }
            // minCost = Math.min(process(nextGold, nextResArr, minCost, goldBar.length + preCost), minCost);
            int niuma = process(nextGold, nextResArr, minCost, goldBar.length + preCost, resList);
            if (niuma < minCost) {
                System.out.println(goldBar.length);
                minCost = niuma;
            }
        }
        return minCost;
    }

    public static int[] removeiGetArr(int[] resArr, int i) {
        int addIndex = 0;
        final int N = resArr.length;
        int[] nextResArr = new int[N - 1];
        for (int j = 0; j < N; j++) {
            if (j != i) {
                nextResArr[addIndex++] = resArr[j];
            }
        }
        return nextResArr;
    }

    // 贪心算法解决
    public static class CompareValue implements Comparator<TreeNode> {

        @Override
        public int compare(TreeNode o1, TreeNode o2) {
            return o1.value - o2.value;
        }
    }

    public static Integer[] getTarget(GoldBar goldBar, int[] resArr) {
        PriorityQueue<TreeNode> goldBarLenPriorityQueue = new PriorityQueue<>(new CompareValue());
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < resArr.length; i++) {
            goldBarLenPriorityQueue.add(new TreeNode(resArr[i]));
        }
        TreeNode treeNode = null;
        while (goldBarLenPriorityQueue.size() > 1) {
            TreeNode one = goldBarLenPriorityQueue.poll();
            TreeNode two = goldBarLenPriorityQueue.poll();
            treeNode = new TreeNode(one.value + two.value);
            treeNode.left = one;
            treeNode.right = two;
            goldBarLenPriorityQueue.add(treeNode);
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode curTreeNode = queue.poll();
            if (curTreeNode.right != null) {
                queue.add(curTreeNode.right);
            }
            if (curTreeNode.left != null) {
                queue.add(curTreeNode.left);
            }
            if (curTreeNode.left != null && curTreeNode.right != null) {
                resList.add(curTreeNode.value);
            }
        }

        return resList.toArray(new Integer[resList.size()]);
    }

}
