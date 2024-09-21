package com.yang.dachang.timet24t09.time20;

/**
 * 数字拆分问题 -> 去for动归
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(int n) {
        if (n == 0 || n == 1) return n;
        return process(n);
    }

    public static int process(final int N) {
        int[][] dp = new int[N + 1][N + 1];
        for (int row = 1, col = 1; row <= N && col <= N; row++, col++) {
            dp[row][0] = 1;
            dp[row][col] = 1;
        }
        // 下 -> 上; 左 -> 右
        for (int pre = N - 1; pre > 0; pre--) {
            for (int rest = pre + 1; rest <= N; rest++) {
                dp[pre][rest] = dp[pre][rest - pre] + dp[pre + 1][rest];
            }
        }
        return dp[1][N];
    }

}
