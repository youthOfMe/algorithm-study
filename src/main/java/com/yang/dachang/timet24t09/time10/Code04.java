package com.yang.dachang.timet24t09.time10;

/**
 * 高手博弈（动态规划）
 */
public class Code04 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 100, 7}));
    }

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        final int N = arr.length;
        int[][] f = new int[N][N];
        int[][] g = new int[N][N];

        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }

        for (int i = 1; i < N; i++) {
            // 定义left为列，right为行
            int left = 0;
            int right = i;
            while (left < N && right < N) {
                f[left][right] = Math.max(
                        arr[left] + g[left + 1][right],
                        arr[right] + g[left][right - 1]
                );
                g[left][right] = Math.min(
                        f[left + 1][right],
                        f[left][right - 1]
                );
                left++;
                right++;
            }
        }
        return Math.max(
                f[0][N - 1],
                g[0][N - 1]
        );
    }

}
