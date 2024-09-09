package com.yang.dachang.timet24t09.time08;

/**
 * 高手摸牌博弈论
 */
public class Code06 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 100, 7}));
    }

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(
                f(0, arr.length - 1, arr),
                g(0, arr.length - 1, arr)
        );
    }

    public static int f(int left, int right, int[] arr) {
        if (left == right) return arr[left];
        return Math.max(
                arr[left] + g(left + 1, right, arr),
                arr[right] + g(left, right - 1, arr)
        );
    }

    public static int g(int left, int right, int[] arr) {
        if (left == right) return 0;
        return Math.min(
                f(left + 1, right, arr),
                f(left, right - 1, arr)
        );
    }

}
