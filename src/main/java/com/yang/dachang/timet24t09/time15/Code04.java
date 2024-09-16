package com.yang.dachang.timet24t09.time15;

/**
 * 组合货币的方法数（面额数组） -> 假动态规划
 */
public class Code04 {

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
            for (int rest = 0; rest < aim; rest++) {
                for (int zhang = 0; dp[index][rest] - zhang * arr[index] >= 0; zhang++) {
                    dp[index][rest] += dp[index + 1][dp[index][rest] - zhang * arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

}
