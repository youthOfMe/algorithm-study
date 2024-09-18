package com.yang.dachang.timet24t09.time16;

import java.util.HashMap;
import java.util.Map;

/**
 * 新货币组合问题（面值单张数组）-> 暴力递归
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] coins, int[] zhangs) {
            this.coins = coins;
            this.zhangs = zhangs;
        }
    }

    public static Info getInfo(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                map.put(item, map.get(item) + 1);
            }
        }
        int[] coins = new int[map.size()];
        int[] zhangs = new int[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            coins[index] = entry.getKey();
            zhangs[index++] = entry.getValue();
        }
        return new Info(coins, zhangs);
    }

    public static int getTarget(int[] arr, int aim) {
        Info info = getInfo(arr);
        return process(info.coins, info.zhangs, aim, 0);
    }

    public static int process(int[] coins, int[] zhangs, int rest, int index) {
        if (coins.length == index) return rest == 0 ? 1 : 0;
        int ways = 0;
        for (int zhang = 0; rest - coins[index] * zhang >= 0 && zhang <= zhangs[index]; zhang++) {
            ways += process(coins, zhangs, rest - coins[index], index + 1);
        }
        return ways;
    }

    public static int getTarget2(int[] arr, int aim) {
        Info info = getInfo(arr);
        return dp1(info.coins, info.zhangs, aim);
    }

    public static int dp1(int[] coins, int[] zhangs, int aim) {
        final int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                for (int zhang = 0; zhang <= zhangs[index] && rest - zhang * coins[index] >= 0; zhang++) {
                    dp[index][rest] += dp[index + 1][rest - zhang * coins[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static int getTarget3(int[] arr, int aim) {
        Info info = getInfo(arr);
        return dp2(info.coins, info.zhangs, aim);
    }

    public static int dp2(int[] coins, int[] zhangs, int aim) {
        final int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) {
                    dp[index][rest] += dp[index][rest - coins[index]];
                }
                if (rest - coins[index] * (zhangs[index] + 1) >= 0) {
                    dp[index][rest] -= dp[index + 1][rest - coins[index] * (zhangs[index] + 1)];
                }
            }
        }
        return dp[0][aim];
    }

}
