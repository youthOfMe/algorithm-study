package com.yang.dachang.timet24t10.time18;

import com.yang.dachang.timet24t08t08.IndexHeap;

import java.util.Arrays;

/**
 * 整个大根堆
 */
public class Heap {

    // 存储的size
    private int size = 0;

    // 存储大根堆数据
    private int[] elements = new int[100];

    // 根据索引数据
    public int get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return elements[index];
    }

    // 添加数据
    public boolean add(int data) {
        elements[size++] = data;
        heapInsert(size - 1);
        return true;
    }

    // 插入数据
    public boolean set(int index, int data) {
        if (index > size - 1) {
            return false;
        }
        elements[index] = data;
        heapInsert(index);
        heapify(index);
        return true;
    }

    // 获取大根堆中的所有数据
    public void printAll() {
        System.out.println(Arrays.toString(elements));
    }

    // heapInsert -> 向上比较移动
    private void heapInsert(int index) {
        while (elements[(index - 1) / 2] < elements[index]) {
            swap(elements, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    // heapify -> 向下比较移动
    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < size) {
            int right = left + 1;
            int biggest = elements[left] > elements[index] ? left : index;
            biggest = right < size && elements[right] > elements[biggest] ? right : biggest;
            if (biggest == index) {
               break;
            }
            swap(elements, index, biggest);
            index = biggest;
        }
    }

    // 数组中两数交换
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

