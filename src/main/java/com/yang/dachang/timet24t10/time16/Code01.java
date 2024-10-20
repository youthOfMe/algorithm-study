package com.yang.dachang.timet24t10.time16;

import java.util.Arrays;

/**
 * 在N个无序数组arr中, 给定一个整数K, 返回TOP K个最大的数
 * 第一种解法: 使用排序进行解决
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // sort1(arr);
        // System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getTarget(arr, 6)));
    }

    private static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) return null;
        sortArr(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void sortArr(int[] arr) {
        if (arr == null || arr.length < 2) return;
        final int N = arr.length;
        process(arr, 0, N - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int len = right - left + 1;
        int index = 0;
        int[] help = new int[len];

        while (p1 <= mid && p2 <= right) {
            help[index++] = arr[p2] >= arr[p1] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= right) {
            help[index++] = arr[p2++];
        }

        for (index = 0; index < len; index++) {
            arr[index + left] = help[index];
        }
    }

}

