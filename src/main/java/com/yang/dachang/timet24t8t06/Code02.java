package com.yang.dachang.timet24t8t06;

import java.util.Arrays;

// 新题
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 2, 6, 5, 9, 7};
        getTarget(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void getTarget(int[] arr, int k) {
        if (k <= 0 || arr.length < 2) {
            return;
        }

        int slideWindowLeft = 0;
        int slideWindowRight = k;
        int[] help = new int[k + 1];
        // 建立 0 - k的小根堆
        for (int i = 0; i < slideWindowRight - slideWindowLeft + 1; i++) {
            help[i] = arr[i];
            heapInsert(help, i);
        }

        int heapSize = slideWindowRight - slideWindowLeft + 1;
        while (heapSize > 0) {
            if (heapSize == k + 1 && slideWindowRight != arr.length - 1) {
                slideWindowLeft++;
                int result = set(help, arr[++slideWindowRight], heapSize);
                arr[slideWindowLeft - 1] = result;
            } else {
                slideWindowLeft++;
                heapSize = slideWindowRight - slideWindowLeft + 1;
                int result = pop(help, heapSize);
                arr[slideWindowLeft - 1] = result;
            }
        }
    }

    public static int set(int[] arr, int data, int heapSize) {
        int result = arr[0];
        arr[0] = data;
        heapify(arr, 0, heapSize);
        return result;
    }

    public static int pop(int[] arr, int heapSize) {
        if (heapSize == 0) {
            return arr[0];
        }
        swap(arr, 0, heapSize);
        heapify(arr, 0, heapSize);
        return arr[heapSize];
    }

    public static void heapInsert(int[] arr, int index) {
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
