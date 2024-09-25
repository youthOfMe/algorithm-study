package com.yang.dachang.timet24t09.time23;

/**
 * 拆分数组 => 两个数组长度相似 - 暴力递归
 */
public class Code02 {

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        if ((arr.length & 1) == 0) {
            return process(arr, 0, arr.length / 2, sum / 2);
        } else {
            return Math.max(process(arr, 0, arr.length / 2, sum / 2), process(arr, 0, arr.length / 2 + 1, sum / 2));
        }
    }

    public static int process(int[] arr, int index, int picks, int rest) {
        if (arr.length == index) {
            return picks == 0 ? 0 : -1;
        } else {
            int p1 = process(arr, index + 1, picks, rest);
            int p2 = -1;
            int next = -1;
            if (picks > 0 && arr[index] <= rest) {
                next = process(arr, index + 1, picks - 1, rest - arr[index]);
            }
            if (next != -1) {
                p2 = next + arr[index];
            }
            return Math.max(p1, p2);
        }
    }

}
