package com.yang.dachang.timet24t10.time13;

import java.util.Arrays;

/**
 * 复习几个简单的排序
 */
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // sort1(arr);
        // System.out.println(Arrays.toString(arr));
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 选择排序
    // 选择排序就是选一个最小/大的进行想前交换
    public static void sort1(int[] arr) {
        if (arr == null || arr.length < 2) return;

        final int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    // 插入排序
    public static void sort2(int[] arr) {
        if (arr == null || arr.length < 2) return;

        final int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                } else {
                    break;
                }
            }
        }
    }

    // 交换函数
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
