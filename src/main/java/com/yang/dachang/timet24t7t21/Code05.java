package com.yang.dachang.timet24t7t21;

/**
 * right * 2 问题
 */
public class Code05 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 4, 3, 1};
        int target = getTarget(arr, 0, arr.length - 1);
        System.out.println(target);
    }

    public static int getTarget(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return getTarget(arr, left, mid) + getTarget(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int ans = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] > arr[p2] * 2) {
                p2++;
            } else {
                p1++;
                ans += p2 - mid;
            }
        }

        p1 = left;
        p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int i = 0;
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

        return ans;
    }
}
