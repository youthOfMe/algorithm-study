package com.yang.dachang.timet24t8t05;

import java.util.Arrays;

public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr) {
        int heapSize = arr.length;
        // 整理数组为大根堆
        for (int i = 0; i < heapSize - 1; i++) {
            heapInsert(arr, i);
        }

        while (heapSize > 2) {
            swap(arr, 0, (heapSize-- - 1));
            heapify(arr, 0, heapSize - 1);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        while (index * 2 + 1 < heapSize) {
            int lastgest = index * 2 + 2 < heapSize && arr[index * 2 + 1] > arr[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;
            lastgest = arr[index] >= arr[lastgest] ? index : lastgest;
            if (index == lastgest) {
                break;
            }
            swap(arr, lastgest, index);
            index = lastgest;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
