package com.yang.dachang.timet24t10.time16;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.omg.CORBA.INTERNAL;

import javax.swing.text.rtf.RTFEditorKit;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * 在N个无序数组arr中, 给定一个整数K, 返回TOP K个最大的数
 * 第三种解法 荷兰国旗，求出整个数组中第K大的数
 * 遍历一边数组就，将 > K的数据收集起来
 * 每收集够就是要补充 = k的数据
 * 时间复杂度: O(N + K * logK)
 */
public class Code03 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        System.out.println(Arrays.toString(getTarget(arr, 5)));
    }

    public static int[] getTarget(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        final int N = arr.length;
        int[] res = new int[k];
        int target = arr[0];
        int left = 0;
        int right = N - 1;
        int rank = (N - 1 - k);
        while (true) {
            int[] kForArr = getKForArr(arr, left, right);
            if (kForArr[0] < rank && kForArr[1] > rank) {
                target = arr[kForArr[0] + 1];
                break;
            } else if (kForArr[0] >= rank) {
                right = kForArr[0];
            } else {
                left = kForArr[1];
            }
        }
        Arrays.fill(res, -1);
        int resIndex = 0;
        for (int index = N - 1; index >= 0; index--) {
            if (arr[index] > target) {
                res[resIndex++] = arr[index];
            }
            if (resIndex == k) {
                resIndex = 0;
            }
        }
        resIndex = 0;
        while (resIndex < k) {
            if (res[resIndex] == -1) {
                res[resIndex] = target;
            }
            resIndex++;
        }
        mergeSort(res, 0, res.length - 1);
        return res;
    }

    // 归并排序
    public static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) return;
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // merge过程
    private static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int len = right - left + 1;
        int[] help = new int[len];
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

        for (index = 0; index < len; index++) {
            arr[index + left] = help[index];
        }
    }

    // 获取第K大的值
    public static int[] getKForArr(int[] arr, int left, int right) {
        if (left == right) return new int[]{left, left};
        if (left > right) return new int[]{-1, -1};
        int target = (int) (Math.random() * (right - left + 1)) + left;
        swap(arr, target, right);
        return process(arr, left, right);
    }


    public static int[] process(int[] arr, int left, int right) {
        if (left == right) return new int[]{left, left};
        if (left > right) return new int[]{-1, -1};
        int less = left - 1;
        int more = right;
        int index = left;
        while (index < more) {
            if (arr[index] < arr[right]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[right]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        swap(arr, more++, index);
        return new int[]{less, more};
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
