package com.yang.dachang.timet24t09.time14;

/**
 * 组合货币的方法数
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(int aim, int[] arr) {
        return process(0, aim, arr);
    }

    public static int process(int index, int rest, int[] arr) {
        if (rest < 0) return 0;
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        return process(index + 1, rest - arr[index], arr) + process(index + 1, rest, arr);
    }

}

