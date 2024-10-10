package com.yang.dachang.timet24t10.time05;

/**
 * 农场母牛生牛问题
 */
public class Code02 {

    public static void main(String[] args) {
        System.out.println(getTarget(6));
    }

    public static int getTarget(int N) {
        if (N == 1) {
            return 1;
        }
        int[][] base = {
                {1, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        int[][] res = getRes(base, N - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }

    public static int[][] getRes(int[][] base, int pow) {
        final int N = base.length;
        int[][] res = new int[N][N];
        for (int index = 0; index < N; index++) {
            res[index][index] = 1;
        }
        int[][] tmp = base;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = getTempOrRes(res, tmp);
            }
            tmp = getTempOrRes(tmp, tmp);
            pow >>= 1;
        }
        return res;
    }

    public static int[][] getTempOrRes(int[][] m1, int[][] m2) {
        final int mRow1 = m1.length;
        final int mRow2 = m2.length;
        final int mCol2 = m2[0].length;
        int[][] res = new int[mRow1][mCol2];
        for (int row = 0; row < mRow1; row++) {
            for (int col = 0; col < mCol2; col++) {
                for (int k = 0; k < mRow2; k++) {
                    res[row][col] += m1[row][k] * m2[k][col];
                }
            }
        }
        return res;
    }



}
