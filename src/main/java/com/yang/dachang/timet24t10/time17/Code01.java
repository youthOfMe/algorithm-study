package com.yang.dachang.timet24t10.time17;

import java.util.Arrays;

/**
 * 求数组中前k大的数据
 * 快速排序概率性解决问题
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        System.out.println(Arrays.toString(getTarget(arr, 5)));

        int[] newArr = Arrays.copyOf(arr, arr.length);
        mergeSort(newArr, 0, arr.length - 1);
        System.out.println(Arrays.toString(newArr));
        System.out.println(getKForArr(arr, 0, arr.length - 1, 5));
    }

    private static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) return null;
        final int N = arr.length;
        int[] res = new int[N];
        final int rank = N - k;
        int rankVal = getKForArr(arr, 0, N - 1, rank);
        int resIndex = 0;

        // 将大于rankVal的数据都找出来
        for (int index = 0; index < N; index++) {
            if (arr[index] > rankVal) {
                res[resIndex++] = arr[index];
            }
        }
        // 截取数据 -> 准备排序 -> 降低复杂度
        res = Arrays.stream(res).limit(resIndex + 1).toArray();

        // 开始排序
        mergeSort(res, 0, resIndex);

        return Arrays.stream(res).limit(k).toArray();
    }

    // 荷兰国旗算法
    private static int getKForArr(int[] arr, int left, int right, int k) {
        if (left >= right) return Integer.MIN_VALUE;

        int less = left - 1;
        int more = right;
        int index = left;

        int rank =  k - 1;

        while (true) {
            // int random = (int) (Math.random() * (right - left + 1)) + left;
            // swap(arr, right, random);
            while (index < more) {
                if (arr[index] < arr[right]) {
                    swap(arr, index++, ++less);
                } else if (arr[index] > arr[right]) {
                    swap(arr, index, --more);
                } else {
                    index++;
                }
            }

            swap(arr, more++, right);

            if (rank > less && rank < more) {
                return arr[less + 1];
            } else if (rank <= less) {
                right = less;
                less = left - 1;
                more = right;
            } else {
                left = more;
                more = right;
                less = left - 1;
            }

            index = less + 1;
        }
    }

    // merge排序
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // 开始左右数组merge
    private static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int size = right - left + 1;
        int[] help = new int[size];
        int index = 0;

        while (p1 <= mid && p2 <= right) {
            help[index++] = arr[p2] >= arr[p1] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= right) {
            help[index++] = arr[p2++];
        }

        for (index = 0; index < size; index++) {
            arr[index + left] = help[index];
        }
    }

    // 数组两数交换
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
