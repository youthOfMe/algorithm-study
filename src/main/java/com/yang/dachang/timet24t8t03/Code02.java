package com.yang.dachang.timet24t8t03;

import java.util.Arrays;

public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }

        if (left >= right) {
            return;
        }

        int[] quickSort = quickSort(arr, left, right);
        getTarget(arr, left, quickSort[0]);
        getTarget(arr, quickSort[1], right);
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, left};
        }

        int target = right;
        int small = left - 1;
        int big = right;
        int index = left;
        while (index < big) {
            if (arr[index] < arr[target]) {
                swap(arr, ++small, index++);
            } else if (arr[index] == arr[target]) {
                index++;
            } else {
                swap(arr, --big, index);
            }
        }
        swap(arr, big++, target);
        return new int[]{small, big};
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
