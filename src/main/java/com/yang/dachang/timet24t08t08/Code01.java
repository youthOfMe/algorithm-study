package com.yang.dachang.timet24t08t08;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 使用优先级队列完成堆排序
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 2, 6, 5, 9, 7};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.remove();
        }
        System.out.println(Arrays.toString(arr));
    }
}
