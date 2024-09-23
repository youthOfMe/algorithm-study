package com.yang.dachang.timet24t09.time22;

/**
 * 数组拆分为两个最接近的累加和 - 暴力递归
 */
public class Code04 {

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return process(arr, 0, sum / 2);
    }

    public static int  process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return 0;
        } else {
            int p1 = process(arr, index + 1, rest);
            int p2 = 0;
            if (arr[index] <= rest) {
                p2 = arr[index] + process(arr, index + 1, rest - 1);
            }
            return Math.max(p1, p2);
        }
    }

}
