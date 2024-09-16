package com.yang.dachang.timet24t09.time15;

/**
 * 组合货币的方法数（面额数组） -> 暴力
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) return rest == 0 ? 1 : 0;
        int ways = 0;
        for (int zhang = 0; rest - zhang * arr[index] >= 0; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }

}
