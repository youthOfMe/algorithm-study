package com.yang.dachang.timet24t08t30;

/**
 * 测试类
 */
public class Code01 {

    public static void main(String[] args) {
        // 1. 测试小根堆
        testSmallHeap();
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
}
