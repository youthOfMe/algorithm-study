package com.yang.dachang.timet24t09.time20;

/**
 * 数字拆分问题 -> 暴力尝试
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
       return process(1, n);
    }

    public static int process(int pre, int rest) {
        if (pre > rest) {
            return 0;
        }
        if (pre == rest || rest == 0) {
            return 1;
        }
        int ways = 0;
        for (int first = pre; first <= rest; first++) {
            ways += process(first, rest - first);
        }
        return ways;
    }

}
