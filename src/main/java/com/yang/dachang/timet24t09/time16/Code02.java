package com.yang.dachang.timet24t09.time16;

public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget3(int[] arr, int aim) {
        return process3(arr, aim);
    }

    public static int process3(int[] arr, int aim) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[0][aim] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
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
        dp[0][aim] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                for (int zhang = 0; rest - arr[index] * zhang >= 0; zhang++) {
                    dp[index][aim] += dp[index + 1][rest - arr[index] * zhang];
                }
            }
        }
        return dp[0][aim];
    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    public static int process(int[] arr, int rest, int index) {
        if (arr.length == index) return rest == 0 ? 1 : 0;
        int ways = 0;
        for (int zhang = 0; rest - arr[index] * zhang >= 0; zhang++) {
            ways += process(arr, rest - arr[index] * zhang, index + 1);
        }
        return ways;
    }

}
