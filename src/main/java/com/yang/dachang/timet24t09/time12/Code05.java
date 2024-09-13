package com.yang.dachang.timet24t09.time12;

/**
 * 求两字符串最长公共子序列的长度
 */
public class Code05 {

    public static void main(String[] args) {

    }

    public static int getTarget(char[] str1, char[] str2) {
        final int N = str1.length;
        final int M = str2.length;
        int[][] dp = new int[N][M];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < N; i++) {
            if (str1[i] == str2[0]) dp[i][0] = 1;
            else dp[i][0] = 0;
        }
        for (int j = 1; j < M; j++) {
            if (str1[0] == str2[j]) dp[0][j] = 1;
            else dp[0][j] = 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[N - 1][M - 1];
    }

}
