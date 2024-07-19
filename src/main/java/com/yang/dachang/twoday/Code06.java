package com.yang.dachang.twoday;

public class Code06 {

    public static void main(String[] args) {

    }

    /**
     * 返回小于等于目标的值
     *
     * @param arr
     * @param target
     * @return
     */
    public static int getTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == right) {
            ans = left;
        }
        return ans;
    }
}
