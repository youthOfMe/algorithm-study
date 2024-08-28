package com.yang.dachang.timet24t08t28;

import java.util.Arrays;

/**
 * 快速排序2.0
 */
public class Code10 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 2) {
            return;
        }

        if (left >= right) {
            return;
        }

        int[] quickSort = quickSort2(arr, left, right);
        getTarget(arr, left, quickSort[0]);
        getTarget(arr, quickSort[1], right);
    }

    public static int[] quickSort2(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, left};
        }

        int target = right;
        int more = right;
        int less = left - 1;
        int cur = left;
        while (cur < more) {
            if (arr[cur] < arr[target]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] == arr[target]) {
                cur++;
            } else {
                swap(arr, --more, cur);
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
