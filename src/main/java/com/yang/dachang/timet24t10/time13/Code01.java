package com.yang.dachang.timet24t10.time13;

import java.util.Arrays;

/**
 * BFPRT算法
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        System.out.println(arr.length - 1);;
        System.out.println(bfprt(arr, 0, arr.length - 1, 9));
    }

    private static int bfprt(int[] arr, int left, int right, int index) {
        if (left == right) return arr[left];
        if (left > right) return -1;

        int p = medianOfMedians(arr, left, right);
        int[] partition = partition(arr, left, right, p);
        if (index > partition[0] && index < partition[1]) {
            return arr[index];
        } else if (index <= partition[0]) {
            return bfprt(arr, left, partition[0], index);
        } else {
            return bfprt(arr, partition[1], right, index);
        }
    }

    private static int[] partition(int[] arr, int left, int right, int p) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, right};
        }

        int less = left - 1;
        int more = right + 1;
        int index = left;
        while (index < more) {
            if (arr[index] < p) {
                swap(arr, index++, ++less);
            } else if (arr[index] > p) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] mArr = new int[size / 5 + offset];
        final int N = mArr.length;
        for (int team = 0; team < N; team++) {
            int teamFirst = left + team * 5;
            mArr[team] = getMedian(arr, teamFirst, Math.min(right, teamFirst + 4));

        }

        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int teamFirst, int teamLast) {
        sort(arr, teamFirst, teamLast);
        return arr[(teamFirst + teamLast) / 2];
    }

    // 小规模排序 => 直接选常数时间最短的插入排序
    private static void sort(int[] arr, int left, int right) {
        if (left == right) return;
        for (int i = left + 1; i < right; i++) {
            for (int j = i - 1; j >= left; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                } else {
                    break;
                }
            }
        }
    }

    // 交换数据
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
