package com.yang.dachang.timet24t08t28;

import java.util.Arrays;

/**
 * 复习归并排序（递归版）
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 54, 456, 5, 6, 22, 35, 12, 50, 0};
        getTarget(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] datas, int left, int right) {
        if (left == right) {
            return;
        }
        final int mid = left + ((right - left) >> 1);
        getTarget(datas, left, mid);
        getTarget(datas, mid + 1, right);
        merge(datas, left, mid, right);
    }

    public static void merge(int[] datas, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[right - left + 1];

        while (p1 <= mid && p2 <= right) {
            help[i++] = datas[p1] <= datas[p2] ? datas[p1++] : datas[p2++];
        }

        while (p1 <= mid) {
            help[i++] = datas[p1++];
        }

        while (p2 <= right) {
            help[i++] = datas[p2++];
        }

        for (i = left; i <= right; i++) {
            datas[i] = help[i - left];
        }
    }
}
