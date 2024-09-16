package com.yang.dachang.timet24t09.time15;

/**
 * 返回货币组合（货币数组）-> 暴力递归
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    public static int process(int[] arr, int rest, int index) {
        if (rest < 0) return 0;
        if (index == arr.length) return rest == 0 ? 1 : 0;
        return process(arr, rest, index + 1) + process(arr, rest - arr[index], index + 1);
    }

}
