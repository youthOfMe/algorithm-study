package com.yang.dachang.timet24t09.time25;

/**
 * 滑动窗口第一题 - 暴力递归
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int[] right(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) return null;
        int N = arr.length;;
        int[] res = new int[N - w + 1];
        int index = 0;
        int L = 0;
        int R = w - 1;
        while (R < N) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);
            }
            res[index++] = max;
            L++;
            R++;
        }
        return res;
    }

}
