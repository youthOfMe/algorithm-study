package com.yang.dachang.timet24t10.time05;

/**
 * 斐波那契数列logN求解
 */
public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget(9));
        System.out.println(getTarget2(9));
    }

    // 斐波那契数列O（N）求解方案
    public static int getTarget(int N) {
        if (N < 0) return 0;
        return process(N);
    }

    public static int process(int N) {
        if (N == 1 || N == 2) return 1;
        return process(N - 1) + process(N - 2);
    }

    // 斐波那契数列O（logN）求解方案 -> 线性代数行列式
    public static int getTarget2(int N) {
        if (N < 0) return 0;
        if (N == 1 || N == 2) return 1;
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, N - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] base, int pow) {
        final int N = base.length;
        // res初始化为单位矩阵
        int[][] res = new int[N][N];
        for (int index = 0; index < N; index++) {
            res[index][index] = 1;
        }

        // 矩阵的一次方
        int[][] tmp = base;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
            pow >>= 1;
        }

        return res;
    }

    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
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
