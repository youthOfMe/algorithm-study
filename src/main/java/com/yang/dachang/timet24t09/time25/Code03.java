package com.yang.dachang.timet24t09.time25;

import java.util.LinkedList;

/**
 * 滑动窗口第一题 - 双端队列优化
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int[] getTarget(int[] arr, int W) {
        if (arr == null || arr.length < W || W < 1) {
            return null;
        }
        final int N = arr.length;
        LinkedList<Integer> qMax = new LinkedList<>();
        int index = 0;
        int[] res = new int[N - W + 1];
        for (int R = 0; R < N; R++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                qMax.pollLast();
            }
            qMax.add(R);
            if (qMax.peekFirst() == R - W) {
                qMax.pollFirst();
            }
            if (R >= W - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }

}
