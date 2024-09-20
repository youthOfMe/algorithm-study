package com.yang.dachang.timet24t09.time19;

/**
 * 面值数组，无限货币，目标值，最少组合数量 -> 暴力递归
 */
public class Code05 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, aim);
    }

    public static int process(int[] arr, int aim) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int i = 1; i <= aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int zhang = 0; rest - arr[index] * zhang >= 0; zhang++) {
                    int next = dp[index + 1][rest - arr[index] * zhang];
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(next + zhang, ans);
                    }
                }
                dp[index][rest] = ans;
            }
        }
        return dp[0][aim];
    }

}
