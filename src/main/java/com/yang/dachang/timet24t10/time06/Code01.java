package com.yang.dachang.timet24t10.time06;

/**
 * 线性代数 => 达标字符串问题
 */
public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget(5));
    }

    public static int getTarget(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = getResArr(base, n - 2);
        return 2 * res[0][0] + res[0][1];
    }

    public static int[][] getResArr(int[][] base, int pow) {
        final int row = base.length;
        final int col = base[0].length;
        // 构造单位矩阵
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            res[i][i] = 1;
        }
        // 构造变次方矩阵
        int[][] temp = base;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = matrixMulti(res, temp);
            }
            pow >>= 1;
            temp = matrixMulti(temp, temp);
        }
        return res;
    }

    public static int[][] matrixMulti(int[][] m1, int[][] m2) {
        final int mRow1 = m1.length;
        final int mCol1 = m1[0].length;
        final int mRow2 = m2.length;
        final int mCol2 = m2[0].length;
        int[][] res = new int[mRow1][mCol1];
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
