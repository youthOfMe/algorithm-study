package com.yang.dachang.timet24t09.time18;

/**
 * 怪兽会死的概率 -> 初版动态规划
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static double getTarget(int hp, int times, int M) {
        return (double) process(hp, times, M) / (double) Math.pow(M + 1, times);
    }

    public static long process(int hp, int times, int M) {
        long[][] dp = new long[times + 1][hp + 1];
        dp[0][0] = 1;
        return 0;
    }

}
