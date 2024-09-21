package com.yang.dachang.timet24t09.time19;

/**
 * 面值数组，无限货币，目标值，最少组合数量 -> 暴力递归 & 初版动态规划 & 斜率优化
 */
public class Code06 {

    public static void main(String[] args) {

    }

    public static int getTarget3(int[] arr, int aim) {}

    public static int process(int[] arr, int aim) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int i = 1; i < aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index++) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = dp[index + 1][rest];
                if (rest - arr[index] >= 0 && dp[index][rest - arr[index]] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[index][rest - arr[index]]);
                }
                dp[index][rest] = ans;
            }
        }

        return dp[0][aim];
    }

    public static int getTarget2(int[] arr, int aim) {
        return process2(arr, aim);
    }

    public static int process2(int[] arr, int aim) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int i = 1; i < aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index++) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int zhang = 0; rest - zhang * arr[index] >= 0; zhang++) {
                    int next = dp[index + 1][rest - zhang * arr[index]];
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(next, ans);
                    }
                }
                dp[index][rest] = ans;
            }
        }

        return dp[0][aim];
    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    public static int process(int[] arr, int rest, int index) {
        if (arr.length == index) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; rest - arr[index] * zhang >= 0; zhang++) {
            int next = process(arr, rest - arr[index] * zhang, index + 1);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + zhang);
            }
        }
        return ans;
    }

}