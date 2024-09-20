package com.yang.dachang.timet24t09.time19;

/**
 * 怪兽会死的概率 - 初版动态规划
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static double getTarget(int hp, int M, int times) {
        return (double) process(hp, M, times) / Math.pow(M + 1, times);
    }

    public static long process(int hp, int M, int times) {
        long[][] dp = new long[times + 1][hp + 1];
        dp[0][0] = 1;
        for (int rest = 1; rest < times; rest++) {
            dp[rest][0] = (long) Math.pow(M + 1, rest);
            for (int restHp = 1; restHp < hp; restHp++) {
                long ways = 0;
                for (int i = 0; i <= M; i++) {
                    if (restHp - i <= 0) {
                        ways += (long) Math.pow(M + 1, times - 1);
                    } else {
                        ways += dp[times - 1][hp - i];
                    }
                }
                dp[rest][restHp] = ways;
            }
        }
        return dp[0][hp];
    }

}
