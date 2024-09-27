package com.yang.dachang.timet24t09.time26;

/**
 * 滑动窗口第二题 -> 暴力
 */
public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public static int getTarget(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        final int N = arr.length;
        int res = 0;
        int left = 0;
        int right = left + 1;
        for (; left < N; left++) {
            for (; right < N; right++) {
                int min = arr[left];
                int max = arr[left];
                for (int index = left + 1; index <= right; index++) {
                    min = Math.min(min, arr[index]);
                    max = Math.max(min, arr[index]);
                }
                res += (max - min <= num) ? 1 : 0;
            }
        }
        return res;
    }

}
