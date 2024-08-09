package com.yang.dachang.timet24t08t08;

import java.util.Comparator;

/**
 * 测试有反向索引的堆
 */
public class Code02 {

    public static void main(String[] args) {
        IndexHeap<Integer> integerIndexHeap = new IndexHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        integerIndexHeap.push(1);
        integerIndexHeap.push(2);
        integerIndexHeap.push(3);
        System.out.println(integerIndexHeap.pop());
        System.out.println(integerIndexHeap.pop());
    }
}
