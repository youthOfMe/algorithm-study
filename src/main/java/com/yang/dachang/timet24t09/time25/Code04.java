package com.yang.dachang.timet24t09.time25;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个固定为w的窗口长度,和一个数组,求每次窗口滑动的时候的最大值记录
 */
public class Code04 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTarget(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(getTarget2(new int[]{1, 2, 3, 4, 5}, 3)));
    }

    public static int[] getTarget(int[] arr, int W) {
        if (arr == null || arr.length < W || W < 1) {
            return null;
        }
        final int N = arr.length;
        int[] res = new int[N - W + 1];
        int left = 0;
        int right = W - 1;
        int i = 0;
        while (right < N) {
            int max = 0;
            for (int index = left; index <= right; index++) {
                max = Math.max(arr[index], max);
            }
            res[i++] = max;
            left++;
            right++;
        }
        return res;
    }

    public static int[] getTarget2(int[] arr, int W) {
        if (arr == null || arr.length < W || W < 1) {
            return null;
        }
        final int N = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[N - W + 1];
        int index = 0;
        for (int R = 0; R < N; R++) {
            if (!queue.isEmpty() && queue.peekFirst() == R - W) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[R]) {
                queue.pollLast();
            }
            queue.addLast(R);
            if (R >= W - 1) res[index++] = arr[queue.peekFirst()];
        }
        return res;
    }

}
