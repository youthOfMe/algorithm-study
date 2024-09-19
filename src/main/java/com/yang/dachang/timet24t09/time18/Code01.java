package com.yang.dachang.timet24t09.time18;

/**
 * 醉鬼是否会死问题 -> 暴力递归 & 动态规划
 */
public class Code01 {

    public static void main(String[] args) {

    }

    // 高级动态规划
    // public static int getTarget3(int col, int row, int rest, int N, int M) {
    //
    // }
    //
    // public static int process3(int col, int row, int rest, int N, int M) {
    //
    // }

    // 动态规划
    public static int getTarget2(int col, int row, int rest, int N, int M) {
        return process2(col, row, rest, N, M);
    }

    public static int process2(int col, int row, int rest, int N, int M) {

        int[][][] dp = new int[rest + 1][N + 1][M + 1];
        for (int colIndex = 0; colIndex < N; colIndex++) {
            for (int rowIndex = 0; rowIndex < M; rowIndex++) {
                dp[0][colIndex][rowIndex] = 1;
            }
        }

        for(int restIndex = 1; restIndex <= rest; restIndex++) {

            for (int colIndex = 0; colIndex <= N; colIndex++) {
                for (int rowIndex = 0 ; rowIndex <= M; rowIndex++) {
                    int up = colIndex - 1 >= 0 ? dp[restIndex - 1][colIndex - 1][rowIndex] : 0;
                    int down = colIndex + 1 <= N ? dp[restIndex - 1][colIndex + 1][rowIndex] : 0;
                    int left = rowIndex - 1 >= 0 ? dp[restIndex - 1][colIndex][rowIndex - 1] : 0;
                    int right = rowIndex - 1 <= M ? dp[restIndex - 1][colIndex][rowIndex + 1] : 0;
                    dp[restIndex][colIndex][rowIndex] = up + down + left + right;
                }
            }
        }

        return dp[rest][col][row];
    }

    // 暴力递归
    public static int getTarget(final int col, final int row, final int rest, final int N, final int M) {
        return process(col, row, rest, N, M);
    }

    public static int process(int col, int row, int rest, final int N, final int M) {
        if (col < 0 || col > N || row < 0 || row > M) {
            return 0;
        }
        if (rest <= 0) {
            return 1;
        }
        int up = process(col, row - 1, rest - 1, N ,M);
        int down = process(col, row + 1, rest - 1, N, M);
        int left = process(col - 1, row, rest - 1, N, M);
        int right = process(col + 1, row, rest - 1, N, M);
        return up + down + left + right;
    }

}
