package com.yang.dachang.timet24t09.time28;

import java.util.HashMap;

/**
 * 滑动窗口四题 - 货币数组 -> 整理尝试
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 3, 5, 1, 1, 1, 5, 3, 2};
        System.out.println(getTarget2(arr, 15));
        System.out.println(getTarget(arr, 15) == getTarget2(arr, 15));
    }

    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] coins, int[] zhangs) {
            this.coins = coins;
            this.zhangs = zhangs;
        }
    }

    public static Info getInfos(int[] arr) {
        HashMap<Integer, Integer> zhangMap = new HashMap<>();
        for (int item : arr) {
            if (!zhangMap.containsKey(item)) {
                zhangMap.put(item, 1);
            } else {
                zhangMap.put(item, zhangMap.get(item) + 1);
            }
        }
        int[] coins = new int[zhangMap.size()];
        int[] zhangs = new int[zhangMap.size()];
        int index = 0;
        for (Integer key : zhangMap.keySet()) {
            coins[index] = key;
            zhangs[index++] = zhangMap.get(key);
        }
        return new Info(coins, zhangs);
    }

    public static int getTarget(int[] arr, int aim) {
        Info info = getInfos(arr);
        return process(info.coins, info.zhangs, 0, aim);
    }

    public static int process(int[] coins, int[] zhangs, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 0 : -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; zhang <= zhangs[index] && rest - zhang * coins[index] >= 0; zhang++) {
            int next = process(coins, zhangs, index + 1, rest - zhang * coins[index]);
            if (next != -1) {
                ans = Math.min(ans, zhang + next);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int getTarget2(int[] arr, int aim) {
        Info info = getInfos(arr);
        return dp(info.coins, info.zhangs, aim);
    }

    public static int dp(int[] coins, int[] zhangs, int aim) {
        final int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int index = 0; index <= N; index++) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = -1;
            }
        }
        dp[N][0] = 0;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int zhang = 0; zhang <= zhangs[index] && zhang * coins[index] <= rest; zhang++) {
                    int next = dp[index + 1][rest - coins[index] * zhang];
                    if (next != -1) {
                        ans = Math.min(ans, zhang + next);
                    }
                }
                dp[index][rest] = ans == Integer.MAX_VALUE ? -1 : ans;
            }
        }
        return dp[0][aim];
    }

}

