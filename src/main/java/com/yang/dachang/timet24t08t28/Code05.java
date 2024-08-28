package com.yang.dachang.timet24t08t28;

/**
 * left > right * 2问题V1
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
        final int mid = left + ((right - left) >> 1);
        return getTarget(arr, left, mid) + getTarget(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int res = 0;
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int[] help = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] > arr[p2] * 2) {
                p2++;
            } else {
                p1++;
                res += p2 - mid;
            }
        }
        p1 = left;
        p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = help[i - left];
        }

        return res;
    }
}
