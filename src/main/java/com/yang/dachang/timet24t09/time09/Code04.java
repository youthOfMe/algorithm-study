package com.yang.dachang.timet24t09.time09;

/**
 * 高手博弈问题
 */
public class Code04 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 100, 7}));
    }

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(
                f(arr, 0, arr.length - 1),
                g(arr, 0, arr.length - 1)
        );
    }

    public static int f(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        return Math.max(
                arr[left] + g(arr, left + 1, right),
                arr[right] + g(arr, left, right - 1)
        );
    }

    public static int g(int[] arr, int left, int right) {
        if (left == right) return 0;
        return Math.min(
                f(arr, left + 1, right),
                f(arr, left, right - 1)
        );
    }

}
