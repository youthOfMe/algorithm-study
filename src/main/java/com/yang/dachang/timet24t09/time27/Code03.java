package com.yang.dachang.timet24t09.time27;

/**
 * 活动窗口四题 - 货币数组 -> 经典尝试
 */
public class Code03 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 3, 5, 1, 1, 1, 5, 3, 2};
        System.out.println(getTarget(arr, 15) == dp(arr, 15));
        System.out.println(dp(arr, 15));
    }

    public static int getTarget(int[] arr, int aim) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 0 : -1;
        }

        int ans = Integer.MAX_VALUE;
        int next = process(arr, index + 1, rest);
        if (next != -1) {
            ans = Math.min(ans, next);
        }
        if (rest >= arr[index]) {
            next = process(arr, index + 1, rest - arr[index]);
            if (next != -1) {
                ans = Math.min(ans, next + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int dp(int[] arr, int aim) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int index = 0; index <= N; index++) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = -1;
            }
        }
        dp[N][0] = 0;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int min = Integer.MAX_VALUE;
                if (dp[index + 1][rest] != -1) {
                    min = Math.min(min, dp[index + 1][rest]);
                }
                if (rest - arr[index] >= 0 && dp[index + 1][rest - arr[index]] != -1) {
                    min = Math.min(min, dp[index + 1][rest - arr[index]] + 1);
                }
                dp[index][rest] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }
        return dp[0][aim];
    }


}
