package com.yang.dachang.timet24t8t01;


import java.util.Arrays;

public class Code01 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        getTarget(arr, 0, arr.length - 1);
        String string = Arrays.toString(arr);
        System.out.println(string);
    }

    public static void getTarget(int[] arr, int left, int right) {
        // 处理边界条件，单数本身就有顺序
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        getTarget(arr, left, mid);
        getTarget(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = 0;
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = help[i - left];
        }
    }
}
