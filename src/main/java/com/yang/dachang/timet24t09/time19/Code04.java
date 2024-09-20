package com.yang.dachang.timet24t09.time19;

/**
 * 面值数组，无限货币，目标值，最少组合数量 -> 暴力递归
 */
public class Code04 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    public static int process(int[] arr, int rest, int index) {
        if (index == arr.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; rest - arr[index] * zhang >= 0; zhang++) {
            int next = process(arr, rest - arr[index] * zhang, index++);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + zhang);
            }
        }
        return ans
    }

}
