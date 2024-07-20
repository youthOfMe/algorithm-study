package com.yang.dachang.timet24t7t19;

/**
 * 递归求数组最大值
 */
public class Code01 {
    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMin = getTarget(arr, left, mid - 1);
        int rightMin = getTarget(arr, mid + 1, right);
        return Math.max(leftMin, rightMin);
    }
}
