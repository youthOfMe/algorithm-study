package com.yang.dachang.timet24t09.time20;

/**
 * 数字拆分问题 -> 暴力递归
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(int n) {
        return process(n);
    }

    public static int process(int n) {
        int[][] dp = new int[n][n];
        for (int row = 1, col = 1; row <= n && col <= n; row++, col++) {
            dp[row][0] = 1;
            dp[row][col] = 1;
        }
        for (int pre = n - 1; pre > 0; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                int ways = 0;
                for (int first = pre; first <= rest - pre; first++) {
                    ways += dp[first][rest - pre];
                }
                dp[pre][rest] = ways;
            }
        }
        return dp[1][n];
    }

}
