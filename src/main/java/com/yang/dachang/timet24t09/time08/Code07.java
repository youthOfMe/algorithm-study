package com.yang.dachang.timet24t09.time08;

/**
 * 高手摸牌博弈（动态规划）
 */
public class Code07 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            // 建立对角线
            f[i][i] = arr[i];
        }
        for (int i = 1; i < N; i++) {
            int L = 0;
            int R = i;
            while (L < N && R < N) {
                f[L][R] = Math.max(
                        arr[L] + s[L + 1][R],
                        arr[R] + s[L][R - 1]
                );
                s[L][R] = Math.min(
                        f[L + 1][R],
                        f[L][R - 1]
                );

                L++;
                R++;
            }
        }
        return Math.max(
                f[0][N],
                s[0][N]
        );
    }

}
