package com.yang.dachang.timet24t10.time16;

import jdk.nashorn.internal.ir.BaseNode;

/**
 * 在N个无序数组arr中, 给定一个整数K, 返回TOP K个最大的数
 * 第一种解法: 使用大根堆
 * 自上向下建堆
 * 从顶向外弹出数据
 */
public class Code02 {

    public static void main(String[] args) {

    }

    private static class Heap {
        private int[] elements;
        private int size = 0;

        public Heap(int len) {
            elements = new int[len];
        }

        // 根据索引获取数据
        public int get(int index) {
            if (index > size - 1) {
                throw new ArrayIndexOutOfBoundsException("索引越界");
            }
            return elements[index];
        }

        public void put(int index) {

        }

        // heapInsert
        public void heapInsert(int index) {
            while (elements[(index - 1) / 2] < elements[index]) {
                swap(elements, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // heapify
        public void heapify(int index) {
            int left = index * 2 + 1;
            while (left < size) {
                int right = left + 1;
                int biggest = elements[index] > elements[left] ? index : left;
                biggest = right < size && elements[biggest] > elements[right] ? biggest : right;
                if (biggest == index) {
                    return;
                }
                swap(elements, biggest, index);
                index = biggest;
                left = index * 2 + 1;
            }
        }


        // 交换函数
        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

    }

}
