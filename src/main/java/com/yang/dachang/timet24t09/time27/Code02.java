package com.yang.dachang.timet24t09.time27;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口第三题, 加油站问题 -> 滑动窗口优化
 */
public class Code02 {

    public static void main(String[] args) {
        int[] gas = {1, 1, 3, 1};
        int[] cost = {2, 2, 1, 1};
        System.out.println(Arrays.toString(getTarget(gas, cost)));
    }

    public static boolean[] getTarget(int[] gas, int[] cost) {
        final int N = gas.length;
        boolean[] res = new boolean[N];
        int[] arr = new int[N];
        for (int index = 0; index < N; index++) {
            arr[index] = gas[index] - cost[index];
        }
        int[] middle = new int[2 * N];
        middle[0] = arr[0];
        for (int index = 1; index < 2 * N; index++) {
            if (index < N) {
                middle[index] = middle[index - 1] + arr[index];
            } else {
                middle[index] = arr[index - N] + middle[index - 1];
            }
        }
        LinkedList<Integer> ansWindows = new LinkedList<>();
        int right = 0;
        int cur = 0;
        while (right < 2 * N) {
            while (!ansWindows.isEmpty() && arr[ansWindows.peekLast()] >= middle[right]) {
                ansWindows.pollLast();
            }
            ansWindows.addLast(right);
            if (right >= N - 1) {
                res[cur++] = middle[ansWindows.peekFirst()] - (right > N - 1 ? middle[right - N] : 0) >= 0;
            }
            if (right >= N - 1 && ansWindows.peekFirst() == right) {
                ansWindows.pollFirst();
            }
            right++;
        }
        return res;
    }

}
