package com.yang.dachang.timet24t09.time24;

/**
 * N皇后问题 => 初版
 */
public class Code02 {

    public static void main(String[] args) {
        System.out.println(getTarget(7));
    }

    public static int getTarget(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process(0, record, n);
    }

    public static int process(int i, int[] record, int n) {
        if (i == n) return 1;
        int res = 0;
        for (int index = 0; index < n; index++) {
            if (valid(record, index, i)) {
                record[i] = index;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean valid(int[] record, int col, int row) {
        for (int j = 0; j < row; j++) {
            if (record[j] == col || Math.abs(j - row) == Math.abs(record[j] - col)) {
                return false;
            }
        }
        return true;
    }

}
