package com.yang.dachang.timet24t09.time06;

import java.util.Arrays;

/**
 * 机器人次数问题
 */
public class Code03 {

    public static void main(String[] args) {
        System.out.println(getTarget3(5, 2, 4, 6));
    }

    // 动态递归第二次优化
    public static int getTarget3(int N, int start, int aim, int k) {
        if (N < 2 || start < 0 || start > N || aim < 0 || aim > N || k <= 0) {
            return 0;
        }
        int[][] dp = new int[N + 1][k + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][k];
    }

    // 动态递归第一次优化
    public static int getTarget2(int N, int start, int aim, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return process2(start, k, aim, N, dp);
    }

    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = -1;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(cur + 1, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(cur - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    // 暴力递归方式
    public static int getTarget1(int N, int start, int aim, int k) {
        return process1(start, k, aim ,N);
    }

    public static int process1(int cur, int rest, int aim, int N) {
        // 走完了记录一下
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process1(cur + 1, rest - 1, aim, N);
        }
        if (cur == N) {
            return process1(cur - 1, rest - 1, aim, N);
        }
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

}
