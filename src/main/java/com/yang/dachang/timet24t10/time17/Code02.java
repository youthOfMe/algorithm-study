package com.yang.dachang.timet24t10.time17;

import com.yang.dachang.timet24t08t08.IndexHeap;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * 求数组中前K大的数据
 * BFPRT算法解决 -> 将概率化转化为确定化
 */
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        System.out.println(bfprt(arr, 0, arr.length - 1, 5));
    }

    public static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) return null;
        final int N = arr.length;
        final int rank = N - k;
        return null;
    }

    // BFPRT算法
    private static int bfprt(int[] arr, int left, int right, int k) {

        if (left >= right) return Integer.MIN_VALUE;

        // 1. 将数据按每组五个进行分组
        // 2. 分组后对每组都进行排序
        // 3. 取出每组的中位数数据 -> 整合为一个中位数数组
        // 4. 从中位数数组中取出中位数
        // 获取到非概率性的P数据
        int p = mediumOfMediums(arr, left, right);

        // 进行荷兰国旗处理
        int less = left - 1;
        int more = right + 1;
        int index = less + 1;
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

            if (less <= k && more >= k) {
                return arr[less + 1];
            } else if (less > k) {
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

    // 进行四部分复杂操作
    private static int mediumOfMediums(int[] arr, int left, int right) {
        // 1. 将数据按每组五个进行分组
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int teams = size / 5 + offset;
        int[] midArr = new int[teams];
        for (int team = 0; team < teams; team++) {
            int teamFirst = left + team * 5;
            int teamLast = Math.min(teamFirst + 4, right);
            // 2. 分组后对每组都进行排序
            sortArr(arr, teamFirst, teamLast);
            // 3. 取出每组的中位数数据 -> 整合为一个中位数数组
            int middle = arr[(teamFirst + teamLast) / 2];
            midArr[team] = middle;
        }

        // 4. 从中位数数组中取出中位数
        return bfprt(midArr, 0, arr.length - 1, arr.length / 2);
    }

    // 组内数据排序 -> 使用常数时间小的插入排序即可
    private static void sortArr(int[] arr, int start, int end) {
        if (start == end) return;
        for (int index = start + 1; index < end; index++) {
            for (int idx = index + 1; idx > start; idx--) {
                if (arr[idx] < arr[idx - 1]) {
                    swap(arr, idx, idx - 1);
                } else {
                    break;
                }
            }
        }
    }

    // 交换数组内的两个数
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
