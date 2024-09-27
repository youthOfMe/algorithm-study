package com.yang.dachang.timet24t09.time26;

import java.util.LinkedList;

/**
 * 滑动窗口第二题 -> 双端队列优化
 */
public class Code02 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public static int getTarget(int[] arr, int num) {
        final int N = arr.length;
        int res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int R = 0;
        for (int L = 0; L < N; L++) {
            while (R < N) {
                while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[R]) {
                    maxQueue.pollLast();
                }
                while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[R]) {
                    minQueue.pollLast();
                }
                maxQueue.addLast(R);
                minQueue.addLast(R);
                if (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > num) {
                    break;
                } else {
                    R++;
                }
            }
            res += R - L;
            if (maxQueue.peekFirst() == L) {
                maxQueue.pollFirst();
            }
            if (minQueue.peekFirst() == L) {
                minQueue.pollFirst();
            }
        }
        return res;
    }

}
