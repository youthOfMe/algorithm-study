package com.yang.dachang.timet24t09.time24;

/**
 * 拆分数组 => 两个数组长度相似 - 动态递归
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget2(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        if (((arr.length) & 1) == 0) {
            return process2(arr, sum / 2, arr.length);
        } else {
            return Math.max(process2(arr, sum / 2, arr.length / 2), process2(arr, sum / 2, arr.length + 1));
        }
    }

    public static int process2(int[] arr, int target, int picks) {
        final int N = arr.length;
        int[][][] dp = new int[N + 1][target + 1][picks + 1];
        for (int index = 0; index <= N; index++) {
            for (int rest = 0; rest <= target; rest++) {
                for (int pick = 0; pick <= picks; pick++) {
                    dp[index][rest][pick] = -1;
                }
            }
        }
        for (int rest = 0; rest <= target; rest++) {
            dp[N][rest][0] = 0;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= target; rest++) {
                for (int pick = 0; pick <= picks; pick++) {
                    int p1 = dp[index + 1][rest][pick];
                    int p2 = -1;
                    int next = -1;
                    if (pick > 0 && rest - arr[index] >= 0) {
                        next = dp[index + 1][rest - arr[index]][pick - 1];
                    }
                    if (next != -1) {
                        p2 = arr[index] + next;
                    }
                    dp[index][rest][pick] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][target][picks];
    }

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        if (((arr.length) & 1) == 0) {
            return process(arr, 0, sum / 2, arr.length / 2);
        } else {
            return Math.max(process(arr, 0, sum / 2, arr.length / 2), process(arr, 0, sum / 2, arr.length / 2 + 1));
        }
    }

    public static int process(int[] arr, int index, int rest, int picks) {
        if (arr.length == index) {
            return picks == 0 ? 0 : -1;
        }
        int p1 = process(arr, index + 1, rest, picks);
        int p2 = -1;
        int next = -1;
        if (picks > 0 && arr[index] <= rest) {
            next = process(arr, index + 1, rest - arr[index], picks - 1);
        }
        if (next != -1) {
            p2 = arr[index] + next;
        }
        return Math.max(p1, p2);
    }

}
