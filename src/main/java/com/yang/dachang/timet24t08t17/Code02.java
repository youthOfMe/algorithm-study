package com.yang.dachang.timet24t08t17;

/**
 * 贪心算法解决金条分配问题
 */
public class Code02 {

    public static void main(String[] args) {
        GoldBar goldBar = new GoldBar(60);
        int[] resArr = new int[]{10, 20, 30};
        int result = getResult(goldBar, resArr);
        System.out.println(result);
    }

    public static class GoldBar {
        int length;

        public GoldBar(int length) {
            this.length = length;
        }
    }

    public static int getResult(GoldBar goldBar, int[] resArr) {
        if (goldBar == null || goldBar.length <= 0) {
            return 0;
        }
        // 算出切第一个的最小值
        int minCost = 0;
        GoldBar curGoldBar = new GoldBar(goldBar.length);
        for (int i = 0; i < resArr.length - 1; i++) {
            minCost += curGoldBar.length;
            curGoldBar = new GoldBar(curGoldBar.length - resArr[i]);
        }
        return process(goldBar, resArr, minCost, 0);
    }

    public static int process(GoldBar goldBar, int[] resArr, int cost, int preCost) {
        if (resArr.length < 2) {
            return preCost;
        }

        int minCost = cost;
        for (int i = 0; i < resArr.length; i++) {
            int curGoldLen = resArr[i];
            int[] nextResArr = removeiGetArr(resArr, i);
            GoldBar nextGold = new GoldBar(goldBar.length - curGoldLen);
            minCost = Math.min(process(nextGold, nextResArr, minCost, goldBar.length + preCost), minCost);
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

}
