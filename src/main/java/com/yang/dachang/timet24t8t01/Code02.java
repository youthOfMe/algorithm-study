package com.yang.dachang.timet24t8t01;

import java.util.Arrays;

/**
 * 作者：洋哥
 * 描述：牛逼
 */
public class Code02 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        int target = getTarget(arr, 0, arr.length - 1);
        String string = Arrays.toString(arr);
        System.out.println(string);
        System.out.println(target);
    }

    public static int getTarget(int[] arr, int left, int right) {
        // 处理边界条件，单数本身就有顺序
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return getTarget(arr, left, mid) + getTarget(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int i = 0;
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int ans = 0;

        while (p1 <= mid && p2 <= right) {
            ans += arr[p1] > arr[p2] ? arr[p1] * (p2 - mid) : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
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

        return ans;
    }
}
