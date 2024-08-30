package com.yang.dachang.timet24t08t28;

/**
 * 测试堆
 */
public class Code11 {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(6);
        heap.add(1);
        heap.set(2, 5);
        heap.add(0);
        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.heapWrap[i]);
        }
    }
}
