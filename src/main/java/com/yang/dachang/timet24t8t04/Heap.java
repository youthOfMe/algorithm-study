package com.yang.dachang.timet24t8t04;

import java.util.Arrays;

/**
 * 实现大根堆
 */
public class Heap {

    public int[] heapWrap = new int[1000];

    private int heapSize = 0;

    public void getAll() {
        System.out.println(Arrays.toString(heapWrap));
    }

    public void add(int num) {
        heapWrap[heapSize++] = num;
        heapInsert(heapSize - 1);
    }

    public int get(int index) {
        if (index > heapSize - 1) {
            throw new RuntimeException("索引越界");
        }

        return heapWrap[index];
    }

    public void set(int num, int index) {
        if (index > heapSize - 1) {
            throw new RuntimeException("索引越界");
        }

        heapWrap[index] = num;
        heapInsert(index);
        heapify(index);
    }

    private void heapInsert(int index) {
        while (heapWrap[(index - 1) / 2] < heapWrap[index]) {
            swap(heapWrap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        while (index * 2 + 1 <= heapSize) {
            int lastgest = index * 2 + 2 <= heapSize && heapWrap[index * 2 + 1] > heapWrap[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;
            lastgest = heapWrap[index] >= heapWrap[lastgest] ? index : lastgest;
            if (lastgest == index) {
                break;
            }
            swap(heapWrap, lastgest, index);
            index = lastgest;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
