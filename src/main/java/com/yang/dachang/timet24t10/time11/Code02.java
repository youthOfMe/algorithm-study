package com.yang.dachang.timet24t10.time11;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 快速排序
 */
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int  left, int right) {
        if (arr == null || arr.length < 2 || left >= right) return;

        int[] quickArr = quickSort(arr, left, right);
        getTarget(arr, left, quickArr[0]);
        getTarget(arr, quickArr[1], right);
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, left};
        }

        int less = left - 1;
        int more = right;
        int index = left;
        int target = right;
        while (index < more) {
            if (arr[index] < arr[target]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[target]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }

        swap(arr, more++, target);
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
