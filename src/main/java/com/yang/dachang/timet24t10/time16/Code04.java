package com.yang.dachang.timet24t10.time16;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 在N个无序数组arr中, 给定一个整数K, 返回TOP K个最大的数
 * 第四种解法 BFPRT算法，求出整个数组中第K大的数
 * 遍历一边数组就，将 > K的数据收集起来
 * 每收集够就是要补充 = k的数据
 * 时间复杂度: O(N + K * logK)
 */
public class Code04 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        System.out.println(Arrays.toString(getTarget(arr, 5)));
    }

    private static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) return null;
        final int N = arr.length;
        int[] res = new int[N];
        int rank = N - 1 - k;
        int target = bfprt(arr, 0, N - 1, rank);

        // 进行填充数据
        int resIndex = 0;
        for (int index = 0; index < N; index++) {
            if (arr[index] > target) {
                res[resIndex++] = arr[index];
            }
        }
        while (resIndex < k) {
            res[resIndex++] = target;
        }

        // 截取数据
        res = Arrays.stream(res).limit(resIndex).toArray();
        mergeSort(arr, 0, N - 1);
        // 对数据进行排序
        return Arrays.stream(res).limit(k).toArray();
    }

    // 数据排序 -> 归并排序
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        int size = right - left + 1;
        int[] help = new int[size];

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

    // BFPRT算法
    private static int bfprt(int[] arr, int left, int right, int rank) {
        if (left == right) return arr[left];
        if (left > right) return -1;

        int p = mediumOfMediums(arr, left, right);

        int less = left - 1;
        int more = right + 1;
        int index = left;
        while (true) {
            while (index < more) {
                if (arr[index] < p) {
                    swap(arr, ++less, index++);
                } else if (arr[index] > p) {
                    swap(arr, --more, index);
                } else {
                    index++;
                }
            }

            if (less <= rank && more >= rank) {
                return arr[less + 1];
            } else if (less > rank) {
                more = less + 1;
                right = less;
                less = left - 1;
            } else {
                less = more - 1;
                left = more;
                more = right + 1;
            }

            index = less + 1;
            p = mediumOfMediums(arr, left, right);
        }
    }

    /**
     * 1. 将数组在指定范围上按五个一组进行划分
     * 2. 将分组的所有数组进行排序
     * 3. 排序后将其中的中位数取出组成新数组
     * 4. 组成新数组后, 将新数组中的中位数求出
     * @return
     */
    private static int mediumOfMediums(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] mediums = new int[size / 5 + offset];
        final int N = mediums.length;
        for (int index = 0; index < N; index++) {
            int teamFirst = left + index * 5;
            int teamLast = Math.min(teamFirst + 4, right);
            int medium = getMedium(arr, teamFirst, teamLast);
            mediums[index] = medium;
        }
        return bfprt(mediums, 0, mediums.length - 1, mediums.length / 2);
    }

    // 获取子数组中的中位数
    private static int getMedium(int[] arr, int start, int end) {
        sort(arr, start, end);
        return arr[(start + end) / 2];
    }

    // 小数据规模 -> 使用常数时间最好的插入排序
    private static void sort(int[] arr, int left, int right) {
        for(int i = left; i < right; i++) {
             for (int j = i + 1; j > i; j--) {
                 if (arr[i] > arr[j]) {
                     swap(arr, i, j);
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
