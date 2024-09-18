package com.yang.dachang.timet24t09.time17;

/**
 * 醉鬼是否会死问题
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static double getTarget(int col, int row, int k) {
        return process(col, row, k, col, row) / Math.pow(k, 4);
    }

    public static int process(int col, int row, int rest, int N, int M) {
        if (col < 0 || col > N || row < 0 || row > M) {
            return 0;
        }
        if (rest <= 0) {
            return 1;
        }
        int up = process(col, row - 1, rest - 1, N, M);
        int down = process(col, row + 1, rest - 1, N, M);
        int left = process(col - 1, row, rest - 1, N, M);
        int right = process(col + 1, row, rest - 1, N, M);
        return up + down + left + right;
    }

}
