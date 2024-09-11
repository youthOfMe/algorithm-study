package com.yang.dachang.timet24t09.time10;

/**
 * 字符串转换种数问题（动态规划）
 */
public class Code07 {

    public static void main(String[] args) {

    }

    public static int getTarget(String str) {
        if(str == null || str.isEmpty()) return 0;
        char[] chars = str.toCharArray();
        final int N = chars.length;
        int[] dp = new int[N + 1];
        int ways = 0;
        for (int i = N - 1; i >= 0; i++) {
            if (chars[i] != '0') {
                ways += dp[i + 1];
                if (i + 1 < N && (chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
                    ways += dp[i + 2];
                }
                dp[i] = ways;
            }
        }
        return dp[0];
    }

}
