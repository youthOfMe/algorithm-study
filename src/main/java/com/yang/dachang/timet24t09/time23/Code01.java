package com.yang.dachang.timet24t09.time23;

/**
 * 数组拆分为两个最接近的累加和 - 暴力递归 & 动态规划 - 数组设置全正数
 */
public class Code01 {

    // 动态规划
    public static int getTarget2(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        return process2(arr, sum / 2);
    }

    public static int process2(int[] arr, int target) {
        final int N = arr.length;
        int[][] dp = new int[N + 1][target + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= target; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                if (rest > arr[index]) {
                    p2 = dp[index + 1][rest - arr[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
    }

    // 暴力递归
    public static int getTarget(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        return process(arr, 0, sum / 2);
    }

    public static int process(int[] arr, int index, int rest) {
        if (arr.length == index) return 0;
        int p1 = process(arr, index + 1, rest);
        int p2 = 0;
        if (rest >= arr[index]) {
            p2 = process(arr, index + 1, rest - arr[index]);
        }
        return Math.max(p1, p2);
    }

}
