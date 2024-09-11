package com.yang.dachang.timet24t09.time10;

/**
 * 背包问题
 */
public class Code05 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[] w, int[] v, int bag) {
        if (w == null || w.length == 0 || v == null || v.length == 0 || bag < 0) return 0;
        return process(w, v, bag, 0);
    }

    public static int process(int[] w, int[] v, int bag, int index) {
        if (bag < 0) return -1;
        if (w.length == index) return 0;

        // 不要当前元素
        int p1 = process(w, v, bag, index + 1);
        // 要当前元素
        int p2 = 0;
        int next = process(w, v, bag - w[index], index + 1);
        if (next != -1) {
            p2 = next;
        }
        return Math.max(p1, p2);
    }

}
