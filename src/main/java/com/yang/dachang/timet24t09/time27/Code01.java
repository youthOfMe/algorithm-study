package com.yang.dachang.timet24t09.time27;

import java.util.Arrays;

/**
 * 滑动窗口第三题, 加油站问题 -> 暴力解决
 */
public class Code01 {

    public static void main(String[] args) {
        int[] gas = {1, 1, 3, 1};
        int[] cost = {2, 2, 1, 1};
        System.out.println(Arrays.toString(getTarget(gas, cost)));
    }

    public static boolean[] getTarget(int[] gas, int[] cost) {
        final int N = gas.length;
        boolean[] res = new boolean[N];
        int[] arr = new int[N];
        for (int index = 0; index < N; index++) arr[index] = gas[index] - cost[index];
        for (int outer = 0; outer < N; outer++) {
            int num = arr[outer];
            if (num < 0) {
                res[outer] = false;
                continue;
            }
            boolean isSuccess = true;
            for (int inner = 0; inner < N; inner++) {
                if (num + arr[inner + outer + 1 >= N ? inner + outer + 1 - N : inner + outer + 1] < 0) {
                    isSuccess = false;
                    break;
                }
            }
            res[outer] = isSuccess;
        }
        return res;
    }

}
