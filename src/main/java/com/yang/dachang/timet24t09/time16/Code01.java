package com.yang.dachang.timet24t09.time16;

/**
 * 组合货币的方法数（面额数组） -> 真动态规划
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, aim);
    }

    public static int process(int[] arr, int aim) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] > 0) {
                    dp[index][rest] += dp[index + 1][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

}
