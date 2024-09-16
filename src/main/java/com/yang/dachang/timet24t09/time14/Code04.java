package com.yang.dachang.timet24t09.time14;

/**
 * 组合货币的方法数 -> 动态规划
 */
public class Code04 {

    public static void main(String[] args) {

    }

    public static int getTarget(int aim, int[] arr) {
        return process(aim, arr);
    }

    public static int process(int aim, int[] arr) {
        if (aim == 0) return 1;
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = dp[i + 1][rest] + (rest - arr[i] >= 0 ? dp[i + 1][rest - arr[i]] : 0);
            }
        }
        return dp[0][aim];
    }

}
