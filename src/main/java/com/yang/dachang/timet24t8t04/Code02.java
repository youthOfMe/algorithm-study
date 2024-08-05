package com.yang.dachang.timet24t8t04;

/**
 * 测试大根堆
 */
public class Code02 {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(9);
        heap.add(6);
        heap.add(8);
        heap.add(1);
        heap.getAll();

        heap.set(15, 2);
        heap.getAll();
    }

}
