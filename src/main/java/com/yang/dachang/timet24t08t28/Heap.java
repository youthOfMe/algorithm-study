package com.yang.dachang.timet24t08t28;

/**
 * 实现一个堆
 */
public class Heap {

    public int[] heapWrap = new int[1000];

    public int size = 0;

    public int get(int index) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        return heapWrap[index];
    }

    public void add(int data) {
        heapWrap[size++] = data;
        heapInsert(size - 1);
    }
    
    public void set(int index, int data) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        heapWrap[index] = data;
        heapify(index);
        heapInsert(index);
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int right = 2 * index + 2;
            int small = heapWrap[left] < heapWrap[index] ? left : index;
            small = right < size && heapWrap[right] < small ? right : small;
            if (small == index) {
                return;
            }
            swap(heapWrap, small, index);
            index = small;
            left = small * 2 + 1;
        }
    }
    
    private void heapInsert(int index) {
        while (heapWrap[(index - 1) / 2] > heapWrap[index]) {
            swap(heapWrap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
