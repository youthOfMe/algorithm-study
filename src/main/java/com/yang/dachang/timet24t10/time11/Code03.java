package com.yang.dachang.timet24t10.time11;

import java.util.Arrays;

/**
 * 快速排序的整理思路求第K小 -> 时间复杂度O（N）
 */
public class Code03 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        System.out.println(getTarget(arr, 5));
    }

    public static int getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        return getArrProcess(arr, 0, arr.length - 1, k -1);
    }

    public static int getArrProcess(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return -1;
        }

        int[] leftAndRight = getKProcess(arr, left, right);
        int resLeft = leftAndRight[0];
        int resRight = leftAndRight[1];
        if (resLeft < k && resRight > k) {
            return arr[resLeft + 1];
        } else if (resLeft >= k) {
            return getArrProcess(arr, left, resLeft, k);
        } else {
            return getArrProcess(arr, resRight, right, k);
        }
    }

    public static int[] getKProcess(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, left};
        }

        int less = left - 1;
        int more = right;
        int target = right;
        int index = left;
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
