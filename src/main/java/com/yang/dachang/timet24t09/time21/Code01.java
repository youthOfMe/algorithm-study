package com.yang.dachang.timet24t09.time21;

/**
 * 象棋问题 -> 暴力递归
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(int a, int b, int k) {
        return process(0, 0, k, a, b);
    }

    public static int process(int x, int y, int rest, int a, int b) {
        if (x < 0 || x > 9 || y < 0 || y > 8) return 0;
        if (rest <= 0) return x == a && y == b ? 1 : 0;
        int ways = process(x + 1, y + 2, rest - 1, a, b);
        ways += process(x + 2, y + 1, rest - 1, a, b);
        ways += process(x + 2, y - 1, rest - 1, a, b);
        ways += process(x + 1, y - 2, rest - 1, a, b);
        ways += process(x - 1, y - 2, rest - 1, a, b);
        ways += process(x - 2, y - 1, rest - 1, a, b);
        ways += process(x - 2, y + 1, rest - 1, a, b);
        ways += process(x - 1, y + 2, rest - 1, a, b);
        return ways;
    }

}
