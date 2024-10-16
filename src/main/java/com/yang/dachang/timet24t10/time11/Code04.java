package com.yang.dachang.timet24t10.time11;

import java.util.Arrays;

/**
 * 快速排序的整理思路求第K小 -> 时间复杂度O（N） -> 迭代方式实现
 */
public class Code04 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        System.out.println(getTarget(arr, 11));
    }

    public static int getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        final int N = arr.length;

        int left = 0;
        int right = N - 1;

        int res = k - 1;
        int less = left - 1;
        int more = right;
        int target = right;
        int index = 0;

        while (true) {
            while (index < more) {
                if (arr[index] < arr[target]) {
                    swap(arr, ++less, index++);
                } else if (arr[index] > arr[target]) {
                    swap(arr, --more, index);
                } else {
                    index++;
                }
            }
            swap(arr, target, more++);

            if (less < res && more > res) {
                return arr[less + 1];
            } else if (less >= res) {
                more = less;
                right = less;
                less = left - 1;
            } else {
                less = more;
                left = more;
                more = right;
            }

            index = less + 1;
            target = more;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
