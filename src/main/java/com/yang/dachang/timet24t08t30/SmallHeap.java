package com.yang.dachang.timet24t08t30;

/**
 * 实现小根堆结构
 */
public class SmallHeap {

    private int[] heapWrap;
    private int size = 0;

    public SmallHeap(int size) {
        if (size < 0) {
            throw new RuntimeException("初始化异常, result: size = " + size);
        }
        this.heapWrap = new int[size];
    }

    /**
     * 添加数据
     * @param data
     */
    public void add(int data) {
        if (heapWrap.length == size + 1) {
            throw new ArrayIndexOutOfBoundsException("数据越界");
        }
        heapWrap[size++] = data;
        heapInsert(size - 1);
    }

    /**
     * 插入数据
     * @param index
     * @param data
     */
    public void set(int index, int data) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("数据越界");
        }
        heapWrap[index] = data;
        heapify(index);
        heapInsert(index);
    }

    public int getSize() {
        return size;
    }

    public int getIndex(int index) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("数据越界");
        }
        return heapWrap[index];
    }

    private void heapInsert(int index) {
        while (heapWrap[(index - 1) / 2] > heapWrap[index]) {
            swap((index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < size) {
            int right = left + 1;
            int small = heapWrap[left] < heapWrap[index] ? left : index;
            small = right < size && heapWrap[right] < heapWrap[small] ? right : small;
            if (small == index) {
                return;
            }
            swap(small, index);
            index = small;
            left = 2 * index + 1;
        }
    }

    private void swap(int index1, int index2) {
        int temp = heapWrap[index1];
        heapWrap[index1] = heapWrap[index2];
        heapWrap[index2] = temp;
    }
}
