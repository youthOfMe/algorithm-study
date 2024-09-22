package com.yang.dachang.timet24t09.time21;

/**
 * 象棋问题 -> 动态规划
 */
public class Code02 {

    public static int getTarget(int a, int b, int k) {
        return process(a, b, k);
    }

    public static int process(int a, int b, int k) {
        int[][][] dp = new int[10][9][k + 1];
        dp[a][b][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x <= 9; x++) {
                for (int y = 0; y <= 8; y++) {
                    int ways = pick(dp, x + 1, y + 2, rest - 1);
                    ways += pick(dp, x + 2, y + 1, rest - 1);
                    ways += pick(dp,x + 2, y - 1, rest - 1);
                    ways += pick(dp,x + 1, y - 2, rest - 1);
                    ways += pick(dp,x - 1, y - 2, rest - 1);
                    ways += pick(dp,x - 2, y - 1, rest - 1);
                    ways += pick(dp,x - 2, y + 1, rest - 1);
                    ways += pick(dp,x - 1, y + 2, rest - 1);
                    dp[x][y][rest] = ways;
                }
            }
        }

        return dp[a][b][0];
    }

    public static int pick(int[][][] dp, int x, int y, int rest) {
        if (x < 0 || x > 9 || y < 0 || y > 8) return 0;
        return dp[x][y][rest];
    }

}
