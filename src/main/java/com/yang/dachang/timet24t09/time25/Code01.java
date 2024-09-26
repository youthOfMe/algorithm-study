package com.yang.dachang.timet24t09.time25;

public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget(4));
    }

    public static int getTarget(int n) {
        if (n < 1) return 0;
        return process(n, new int[n], 0);
    }

    // records里面记录col，角标代表row
    public static int process(int n, int[] records, int row) {
        if (n == row) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(i, row, records)) {
                records[row] = i;
                res += process(n, records, row + 1);
            }
        }
        return res;
    }

    public static boolean isValid(int col, int row, int[] records) {
        for (int i = 0; i < row; i++) {
            if (records[i] == col || Math.abs(i - row) == Math.abs(records[i] - col)) {
                return false;
            }
        }
        return true;
    }

}
