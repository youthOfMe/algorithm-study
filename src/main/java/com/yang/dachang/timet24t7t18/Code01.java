package com.yang.dachang.timet24t7t18;

public class Code01 {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        final int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j  : minValueIndex;
            }
            swap(arr, minValueIndex, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {

    }
}
