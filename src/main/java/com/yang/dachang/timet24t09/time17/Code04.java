package com.yang.dachang.timet24t09.time17;

/**
 * 二维表如果走最省路程问题 -> 进阶版本动态规划
 */
public class Code04 {

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
        int[] dp = new int[COL];
        // 第一行
        dp[0] = arr[0][0];
        for (int i = 1; i < COL; i++) {
            dp[i] = arr[0][i - 1] + arr[0][i];
        }
        // 剩下行
        for (int row = 1; row < ROW; row++) {
            dp[0] += arr[row][0];
            for (int col = 1; col < COL; col++) {
                dp[col] = Math.min(dp[col], dp[col - 1]) + arr[row][col];
            }
        }
        return dp[COL - 1];
    }

}
