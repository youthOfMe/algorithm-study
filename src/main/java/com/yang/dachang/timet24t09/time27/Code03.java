package com.yang.dachang.timet24t09.time27;

/**
 * 活动窗口四题 - 货币数组 -> 经典尝试
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] arr, int aim) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (arr.length == index) {
            return rest == 0 ? 1 : 0;
        }
        int p1 = process(arr, index + 1, rest);
        int p2 = -1;
        int next = -1;
        if (rest > arr[index]) {
            next = process(arr, index + 1, rest - arr[index]);
        }
        if (next != -1) {
            p2 = next;
        }
        return Math.min(p1, p2);
    }



}
