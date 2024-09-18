package com.yang.dachang.timet24t09.time17;

/**
 * 二维表如果走最省路程问题 -> 初版动态规划
 */
public class Code03 {

    public static void main(String[] args) {
        int[][] dp = {
                {3, 7, 8, 8},
                {1, 2, 6, 4},
                {10, 3, 8, 9},
                {8, 1, 2, 0}
        };
        int target = getTarget(dp);
        System.out.println(target);
    }

    public static int getTarget(int[][] arr) {
        return process(arr);
    }

    public static int process(int[][] arr) {
        final int COL = arr[0].length;
        final int ROW = arr.length;
        int[][] dp = new int[ROW][COL];
        // 第一行
        dp[0][0] = arr[0][0];
        for (int i = 1; i < COL; i++) {
            dp[0][i] = arr[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < ROW; i++) {
            dp[i][0] = arr[i - 1][0] + arr[i][0];
        }
        for (int col = 1; col < COL; col++) {
            for (int row = 1; row < ROW; row++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + arr[row][col];
            }
        }
        return dp[ROW - 1][COL - 1];
    }

}
