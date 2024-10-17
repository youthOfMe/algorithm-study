package com.yang.dachang.timet24t10.time13;

/**
 * BFPRT算法
 */
public class Code01 {

    public static void main(String[] args) {

    }

    private static int bfprt(int[] arr, int left, int right) {
        if (left == right) return left;
        if (left > right) return -1;

        int p = medianOfMedians(arr, left, right);
        return p;
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;

        return 0;
    }

}
