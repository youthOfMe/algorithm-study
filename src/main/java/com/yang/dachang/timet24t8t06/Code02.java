package com.yang.dachang.timet24t8t06;

import java.util.Arrays;

// 新题
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 2, 9, 5, 7, 6};
        getTarget(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int k) {
        if (k <= 0 || arr.length < 2) {
            return;
        }

        int arrLen = arr.length;
        int slideWindowLeft = 0;
        int slideWindowRight = k;
        int[] help = new int[k + 1];
        // 建立 0 - k的小根堆
        for (int i = slideWindowLeft; i <= slideWindowRight; i++) {
            help[i - slideWindowLeft] = arr[i];
            heapInsert(help, i - slideWindowLeft, slideWindowLeft);
        }
        arr[0] = help[0];
        slideWindowLeft = 1;
        slideWindowRight = slideWindowLeft + (k + 1);
        for (; slideWindowLeft < arrLen; slideWindowLeft++) {
            help[0] = arr[slideWindowLeft];
            heapify(help, 0, slideWindowRight - slideWindowLeft);
            arr[slideWindowLeft - k] = help[0];
            if (slideWindowRight < arrLen) {
                slideWindowRight++;
            }
        }

        // while (slideWindowRight < arrLen) {
        //     for (int i = slideWindowLeft; i <= slideWindowRight; i++) {
        //         help[i - slideWindowLeft] = arr[i];
        //         heapInsert(help, i - slideWindowLeft, slideWindowLeft);
        //     }
        //
        //     slideWindowRight++;
        //     if (slideWindowLeft != arrLen - 1) {
        //         slideWindowLeft++;
        //     }
        // }
        // while (slideWindowRight > 0) {
        //     for (int i = slideWindowLeft; i <= slideWindowRight; i++) {
        //         heapify(arr, i, slideWindowRight - slideWindowLeft + 1);
        //     }
        //     slideWindowRight--;
        //     if (slideWindowLeft != 0) {
        //         slideWindowLeft--;
        //     }
        // }
    }

    public static void heapInsert(int[] arr, int index, int window) {
        while (arr[(index - 1) / 2] > arr[index]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        while (index * 2 + 1 < heapSize) {
            int left = index * 2 + 1;
            int right = left + 1;
            int lagest = right < heapSize && arr[left] > arr[right] ? right : left;
            lagest = arr[index] < arr[lagest] ? index : lagest;
            if (index == lagest) return;
            swap(arr, index, lagest);
            index = lagest;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
