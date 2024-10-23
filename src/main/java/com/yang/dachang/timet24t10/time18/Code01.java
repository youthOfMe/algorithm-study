package com.yang.dachang.timet24t10.time18;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 复习使用BFPRT算法处理获取数组中前K大的数据
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        final int N = arr.length;
        // int[] copyArr = Arrays.copyOf(arr, N);
        // sortArr(copyArr, 0, N - 1);
        // System.out.println(Arrays.toString(copyArr));
        // System.out.println(bfprt(arr, 0, arr.length - 1, 2));
        System.out.println(Arrays.toString(getTarget(arr, 10)));

    }

    // 主函数入口
    private static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) return null;
        final int N = arr.length;
        int[] res = new int[N];
        int rank = N - k;

        // 使用bfprt获取到rank对应的目标值
        int target = bfprt(arr, 0, N - 1, rank);
        int resIdx = 0;
        // 从arr数组中找出比target大的数据
        for (int index = 0; index < N; index++) {
            if (arr[index] > target) {
                res[resIdx++] = arr[index];
            }
        }
        // 补充target数据
        for (; resIdx < k;) {
            res[resIdx++] = target;
        }
        // 截取数据 -> 降低排序复杂度
        res = Arrays.stream(res).limit(resIdx + 1).toArray();
        // 进行排序 -> 使用归并排序
        mergeSort(res, 0, resIdx);
        // 截取数据进行返回
        res = Arrays.stream(res).limit(k).toArray();

        return res;
    }

    // 归并排序
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // 归并排序的流程
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
            arr[left + index] = help[index];
        }
    }

    // BFPRT算法
    private static int bfprt(int[] arr, int left, int right, int rank) {
        if (left >= right) return arr[left];

        /**
         * 1. 将数组中所有元素按照五个一组进行区分
         * 2. 将数组进行排序
         * 3. 将所有数组中的中位数进行抽离为一个中位数数组
         * 4. 从中位数数组中抽离出重用位数进行返回
         */
        int p = mediumOfMediums(arr, left, right);

        // 进入partition过程 返回真正的target
        return partition(arr, 0, right, p, rank);
    }

    // Partition过程
    private static int partition(int[] arr, int left, int right, int p, int rank) {
        // 前置准备
        int less = left - 1;
        int more = right + 1;
        int index = left;
        while (true) {
            while (index < more) {
                if (arr[index] < p) {
                    swap(arr, index++, ++less);
                } else if (arr[index] > p) {
                    swap(arr, index, --more);
                } else {
                    index++;
                }
            }

            if (less < rank && more > rank) {
                return arr[less + 1];
            } else if (less >= rank) {
                more = less + 1;
                right = less;
                less = left - 1;
            } else {
                less = more - 1;
                left = more;
                more = right + 1;
            }

            index = left;
            p = mediumOfMediums(arr, left, right);
        }
    }

    // 获取中位数数组中的中位数数据
    private static int mediumOfMediums(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int teams = size / 5 + offset;
        int[] mediums = new int[teams];
        for (int team = 0; team < teams; team++) {
            int teamFirst = left + team * 5;
            int teamLast = Math.min(teamFirst + 4, right);
            sortArr(arr, teamFirst, teamLast);
            mediums[team] = arr[(teamFirst + teamLast) / 2];
        }
        return bfprt(mediums, 0, mediums.length - 1, mediums.length / 2);
    }

    // 对每个组进行排序 -> 数据量较小直接使用常数时间小的插入排序
    private static void sortArr(int[] arr, int start, int end) {
        for (int index = start + 1; index <= end; index++) {
            for (int inner = index; inner > start; inner--) {
                if (arr[inner] < arr[inner - 1]) {
                    swap(arr, inner, inner - 1);
                }
            }
        }
    }

    // 交换数组中两数的位置
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
