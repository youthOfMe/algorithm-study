package com.yang.dachang.timet24t7t18;

/**
 * 找到局部最小值
 */
public class Code08 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        if (arr[left] < arr[left + 1]) {
            return left;
        }
        if (arr[right] < arr[right - 1]) {
            return right;
        }
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
            }
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
                continue;
            }
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
        }
        return ans;
    }
}
