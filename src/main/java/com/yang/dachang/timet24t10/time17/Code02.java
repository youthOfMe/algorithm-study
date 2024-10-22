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
        // 测试插入排序
        // sortArr(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        // int[] arr = {3, 1, 0, 4, 3, 1};
        // System.out.println(bfprt(arr, 0, arr.length - 1, 5));
        System.out.println(Arrays.toString(getTarget(arr, 9)));
    }

    public static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) return null;
        final int N = arr.length;
        // 规划排名
        final int rank = N - k;
        // 选取正确数据值
        int target = bfprt(arr, 0, N - 1, rank);
        // 准备结果数组
        int[] res = new int[N];
        int resIdx = 0;
        // 将比目标数大的数据进行填充
        for (int index = 0; index < N; index++) {
            if (arr[index] > target) {
                res[resIdx++] = arr[index];
            }
        }
        // 填充一份target数据
        for (; resIdx < k; resIdx++) {
            res[resIdx] = target;
        }
        // 截取数据 -> 降低排序复杂度
        res = Arrays.stream(res).limit(resIdx + 1).toArray();
        // 对数组进行排序
        mergeSort(res, 0, res.length - 1);
        // 截取数组数据
        res = Arrays.stream(res).limit(k).toArray();
        return res;
    }

    // 归并排序算法
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // 归并排序细节过程
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

    // BFPRT算法
    private static int bfprt(int[] arr, int left, int right, int k) {
        // 筛选到最后了
        if (left >= right) return arr[left];

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
        return bfprt(midArr, 0, midArr.length - 1, midArr.length / 2);
    }

    // 组内数据排序 -> 使用常数时间小的插入排序即可
    private static void sortArr(int[] arr, int start, int end) {
        if (start == end) return;
        for (int index = start + 1; index <= end; index++) {
            for (int inner = index; inner > start; inner--) {
                if (arr[inner] < arr[inner - 1]) {
                    swap(arr, inner, inner - 1);
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
