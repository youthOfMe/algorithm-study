package com.yang.dachang.timet24t08t09;

import java.util.Arrays;

/**
 * 基数排序
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, left, right, getMaxDigit(arr));
    }

    public static void process(int[] arr, int left, int right, int maxDigit) {
        if (left >= right) {
            return;
        }

        int[] help = new int[right - left + 1];

        for (int i = 0; i < maxDigit; i++) {
            int[] count = new int[10];
            for (int j = left; j <= right; j++) {
                int digitNum = getDigit(arr[j], i);
                count[digitNum]++;
            }
            for (int k = 1; k < count.length; k++) {
                count[k] = count[k] + count[k - 1];
            }
            for (int z = right; z >= left; z--) {
                int digitNum = getDigit(arr[z], i);
                int wp = count[digitNum];
                help[wp - 1] = arr[z];
                count[digitNum]--;
            }
            for (int q = left; q <= right; q++) {
                arr[q] = help[q - left];
            }
        }

    }

    public static int getMaxDigit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int res = 0;
        while (max > 0) {
            max = max / 10;
            res++;
        }
        return res;
    }

    public static int getDigit(int num, int digit) {
        return (num / (int) Math.pow(10, digit)) % 10;
    }

}
