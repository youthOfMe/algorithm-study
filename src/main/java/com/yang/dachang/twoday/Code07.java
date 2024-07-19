package com.yang.dachang.twoday;

/**
 * 找到大于等于目标值的最右值
 */
public class Code07 {
    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
