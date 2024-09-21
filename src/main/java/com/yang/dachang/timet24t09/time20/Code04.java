package com.yang.dachang.timet24t09.time20;

/**
 * 背包问题 -> 暴力递归 & 动态规划
 */
public class Code04 {

    public static void main(String[] args) {

    }

    public static int getTarget2(int[] value, int[] weight, int bags) {
        return process2(value, weight, bags);
    }

    public static int process2(int[] v, int[] w, final int R) {
        final int N = v.length;
        int[][] dp = new int[N + 1][R + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= R; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = rest - w[index] >= 0 ? dp[index + 1][rest - w[index]] : -1;
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][R];
    }

    public static int getTarget(int[] value, int[] weight, int bags) {
        return process(value, weight, bags, 0);
    }

    public static int process(int[] v, int[] w, int rest, int index) {
        if (rest <= -1) {
            return -1;
        }
        if (index == v.length) return 0;
        int p1 = process(v, w, rest, index + 1);
        int p2 = -1;
        int next = process(v, w, rest - w[index], index + 1);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

}
