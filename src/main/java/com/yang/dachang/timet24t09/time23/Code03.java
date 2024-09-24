package com.yang.dachang.timet24t09.time23;

/**
 * 拆分数组 => 两个数组长度相似 - 动态递归
 */
public class Code03 {

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        return process(arr, sum / 2);
    }

    public static int process(int[] arr, int sum) {
        final int N = arr.length;
        int res = sum / 2;
        int picks = (N + 1) / 2;
        int[][][] dp = new int[N + 1][res + 1][picks + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= res; j++) {
                for (int k = 0; k <= picks; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        for (int i = 0; i <= res; i++) {
            dp[N][i][0] = 0;
        }

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= res; rest++) {
                for (int pick = 0; pick <= picks; pick++) {
                    int p1 = dp[index + 1][rest][pick];
                    int p2 = -1;
                    int next = -1;
                    if (pick - 1 >= 0 && arr[index] >= rest) {
                        next = dp[index][rest - arr[index]][pick - 1];
                    }
                    if (next != -1) {
                        p2 = next;
                    }
                    dp[index][rest][pick] = Math.max(p1, p2);
                }
            }
        }

        if ((arr.length & 1) == 0) {
            return dp[0][res][picks];
        } else {
            return Math.max(dp[0][res][picks], dp[0][res][picks - 1]);
        }
    }

}
