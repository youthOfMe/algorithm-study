package com.yang.dachang.timet24t7t20;

import java.util.Arrays;

public class Code02 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 54, 456, 5, 6, 22, 35, 12, 50, 0};
        getTarget(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        final int N = arr.length ;
        // 当mergeSize大于数组元素总个数之后结束
        while (mergeSize < N) {
            int left = 0;
            while (left < N) {
                // 处理边界条件
                int end = left + mergeSize - 1;
                // 无右组
                if (end >= N) {
                    break;
                }
                int right = Math.min(end + mergeSize, N -1);
                merge(left, right, end, arr);
                left = right + 1;
            }

            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }

            // 步长变大
            mergeSize = mergeSize << 1;
        }
    }

    public static void merge (int left, int right, int mid, int[] arr) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }
}
