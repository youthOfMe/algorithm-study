package com.yang.dachang.timet24t08t28;

import java.util.Arrays;

/**
 * 荷兰国旗问题版本V3
 */
public class Code08 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        getTarget(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getTarget(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, left};
        }

        int less = left - 1;
        int more = right;
        int cur = left;
        int x = arr[right];
        while (cur < more) {
            if (arr[cur] < x) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] == x) {
                cur++;
            } else {
                swap(arr, --more, cur);
            }
        }
        swap(arr, more++, right);

        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
