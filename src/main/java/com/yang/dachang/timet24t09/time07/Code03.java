package com.yang.dachang.timet24t09.time07;

/**
 * 暴力递归-高手博弈
 */
public class Code03 {

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1, 100, 7}));
    }

    public static int getTarget(int[] data) {
        if (data == null || data.length == 0) return 0;
        return Math.max(f(data, 0, data.length - 1), g(data, 0, data.length - 1));
    }

    public static int f(int[] data, int left, int right) {
        if (left == right){
            return data[left];
        }
        return Math.max(
                data[left] + g(data, left + 1, right),
                data[right] + g(data, left, right - 1)
        );
    }

    public static int g(int[] data, int left, int right) {
        if (left == right) {
            return 0;
        }
        return Math.min(
                f(data, left + 1, right),
                f(data, left, right - 1)
        );
    }

}
