package com.yang.dachang.timet24t7t21;

import java.util.Arrays;

public class Code01 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 54, 456, 5, 6, 22, 35, 12, 50, 0};
        getTarget(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int mergeSize = 1;
        final int N = arr.length;
        while (mergeSize <= N) {

            int left = 0;
            while (left < N) {
                int mid = left + mergeSize - 1;
                if (mid >= N) {
                    break;
                }

                int right = Math.min(mid + mergeSize, N - 1);
                merge(left, right, mid, arr);
                left = right + 1;
            }

            if (mergeSize > N / 2) {
                break;
            }


            mergeSize = mergeSize << 1;
        }
    }

    public static void merge (int left, int right, int mid, int[] arr) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }

}
