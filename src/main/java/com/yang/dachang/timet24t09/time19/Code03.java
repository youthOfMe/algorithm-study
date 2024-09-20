package com.yang.dachang.timet24t09.time19;

/**
 * 怪兽会死的概率 - 高级动态规划
 */
public class Code03 {

    public static double getTarget(int hp, int M, int times) {
        return (double) process(hp, M, times) / Math.pow(M + 1, times);
    }

    public static long process(int hp, int M, int times) {
        long[][] dp = new long[times + 1][hp + 1];
        dp[0][0] = 1;
        for (int rest = 1; rest < times; rest++) {
            dp[rest][0] = (long) Math.pow(M + 1, rest);
            for (int restHp = 1; restHp < hp; restHp++) {
                dp[rest][restHp] = dp[rest][restHp - 1] + dp[rest - 1][restHp] - (restHp - (M + 1) > 0 ? dp[rest - 1][restHp - 1 - M] : (long) Math.pow(M + 1, times - 1));
            }
        }
        return dp[0][hp];
    }


}
