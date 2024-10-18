package com.yang.dachang.timet24t10.time14;

/**
 * BFPRT算法
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        System.out.println(getTarget(arr, 0, arr.length - 1, 9));
    }

    private static int getTarget(int[] arr, int left, int right, int index) {
        if (arr == null || arr.length < 2) return -1;
        if (left > right) return -1;
        if (left == right) return arr[left];

        return bfprt(arr, left, right, index);
    }

    // BFPRT算法
    private static int bfprt(int[] arr, int left, int right, int index) {
        int p = mediumOfMediums(arr, left, right);

        int[] partition = partition(arr, left, right, p);
        if (partition[0] < index && index < partition[1]) {
            return arr[index];
        } else if (partition[0] >= index) {
            return getTarget(arr, left, partition[0], index);
        } else {
            return getTarget(arr, partition[1], right, index);
        }
    }

    // 将在left - right范围上的数组进行分组5个一组
    // 将所有分好的组进行组内有序 O(N)
    // 从所有分组中的中位数取出组成新数组
    // 将新组中的中位数进行取出返回
    private static int mediumOfMediums(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] mediums = new int[size / 5 + offset];
        for (int item = 0; item < mediums.length; item++) {
            int teamFirst = left + item * 5;
            mediums[item] = getMediums(arr, teamFirst, Math.min(right, teamFirst + 4));
        }
        return getTarget(mediums, 0, mediums.length - 1, mediums.length / 2);
    }

    // 从所有分组中获取到medium
    private static int getMediums(int[] arr, int left, int right) {
        sort(arr, left, right);
        return arr[(left + right) / 2];
    }

    // 使用插入排序 -> 常数时间小
    private static void sort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    // partition算法
    private static int[] partition(int[] arr, int left, int right, int p) {
        if (left > right) return new int[]{-1, -1};
        if (left == right) return new int[]{left, left};

        int less = left - 1;
        int more = right + 1;
        int index = left;
        while (index < more) {
            if (arr[index] < p) {
                swap(arr, index++, ++less);
            } else if (arr[index] > p) {
                swap(arr, index++, --more);
            } else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    // 数组两数交换算法
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



}
