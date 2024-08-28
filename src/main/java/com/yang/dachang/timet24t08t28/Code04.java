package com.yang.dachang.timet24t08t28;

import java.util.Arrays;

/**
 * 逆序对问题
 */
public class Code04 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 54, 456, 5, 6, 22, 35, 12, 50, 0};
        System.out.println(getTarget(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }

    public static int getTarget(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        final int mid = left + ((right - left) >> 2);
        return getTarget(arr, left, mid) + getTarget(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int res = 0;
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int i = 0;

        while (p1 <= mid && p2 <= right) {
            res += arr[p1] > arr[p2] ? (p2 - mid) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            res += (right - mid);
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = help[i - left];
        }

        return res;
    }

}
