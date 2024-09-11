package com.yang.dachang.timet24t09.time10;

/**
 * 高手摸牌博弈（动态规划2）
 */
public class Code02 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 100, 7}));
    }

    public static int getTarget(int[] arr) {
        final int N = arr.length;
        // N行 N列
        int[][] f = new int[N][N];
        int[][] g = new int[N][N];

        // 规定列 -> right 和 行 -> left
        int right = 0;
        int left = 0;
        while (left < N && right < N) {
            f[left][right] = arr[left];

            left++;
            right++;
        }

        for (int i = 1; i < N; i++) {
            right = i;
            left = 0;
            while (right < N && left < N) {
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
