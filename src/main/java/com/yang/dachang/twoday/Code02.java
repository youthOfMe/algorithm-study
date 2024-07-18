package com.yang.dachang.twoday;


public class Code02 {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        final int N = arr.length;
        for (int end = N - 1; end > 0; end--) {
            for (int second = 0; second < end; second++) {
                if (arr[second] > arr[second + 1]) swap(arr, second, second + 1);
            }
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
