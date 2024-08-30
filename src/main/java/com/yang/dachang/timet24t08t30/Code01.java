package com.yang.dachang.timet24t08t30;

import java.util.Arrays;

/**
 * 测试类
 */
public class Code01 {

    public static void main(String[] args) {
        // 1. 测试小根堆
        testSmallHeap();

        // 2. 测试堆排序
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        testHeapSort1(arr);
    }

    /**
     * 测试小根堆
     */
    public static void testSmallHeap() {
        SmallHeap heap = new SmallHeap(50);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(6);
        heap.add(1);
        heap.set(2, 5);
        for (int i = 0; i < heap.getSize(); i++) {
            System.out.println(heap.getIndex(i));
        }
    }

    /**
     * 测试堆排序
     */
    public static void testHeapSort1(int[] dataArr) {
        /**
         * 堆排序思路：
         *  1. 先上而下建堆
         *  2. 将第一个数和最后一个进行交换
         *  3. size--
         *  4. heapify(0)
         */
        final int LEN = dataArr.length;
        int heapSize = dataArr.length;
        for (int i = 0; i < LEN; i++) {
            heapInsert(dataArr, i);
        }

        while (heapSize > 1) {
            swap(dataArr, 0, (heapSize-- - 1));
            heapify(dataArr, 0, heapSize - 1);
        }
        System.out.println(Arrays.toString(dataArr));
    }

    private static void heapInsert(int[] dataArr, int index) {
        while (dataArr[(index - 1) / 2] > dataArr[index]) {
            swap(dataArr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] dataArr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int right = left + 1;
            int small = dataArr[left] < dataArr[index] ? left : index;
            small = right < heapSize && dataArr[right] < dataArr[small] ? right : small;
            if (small == index) {
                return;
            }
            swap(dataArr, small, index);
            index = small;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] dataArr, int index1, int index2) {
        int temp = dataArr[index1];
        dataArr[index1] = dataArr[index2];
        dataArr[index2] = temp;
    }
}
