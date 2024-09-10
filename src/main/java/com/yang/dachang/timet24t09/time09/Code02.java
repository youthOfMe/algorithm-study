package com.yang.dachang.timet24t09.time09;

/**
 * 背包问题
 */
public class Code02 {

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(getTarget(weights, values, bag));
    }

    public static int getTarget(int[] w, int[] v, int bag) {
        if (w == null || w.length == 0 || v == null || v.length == 0 || bag < 0) return 0;
        return process(w, v, bag, 0);
    }

    public static int process(int[] w, int[] v, int bag, int index) {
        if (bag < 0) return -1;
        if (index == w.length) return 0;

        // 不获取当前货物
        int p1 = process(w, v, bag, index + 1);
        // 获取当前货物
        int p2 = 0;
        int next = process(w, v, bag - w[index], index + 1);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

}
