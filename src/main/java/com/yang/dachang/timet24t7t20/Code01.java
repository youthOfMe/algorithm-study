package com.yang.dachang.timet24t7t20;

import java.util.Arrays;

/**
 * 递归办归并排序
 */
public class Code01 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 54, 456, 5, 6, 22, 35, 12, 50, 0};
        getTarget(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        getTarget(arr, left, mid);
        getTarget(arr, mid + 1, right);
        merge(left, right, mid, arr);
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
