package com.yang.dachang.timet24t09.time07;

/**
 * 斐波那契数列暴力破解
 */
public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget(3));
    }

    public static int getTarget(int N) {
        return process(N);
    }

    public static int process(int N) {
        if (N == 1 || N == 2) return 1;
        return process(N - 1) + process(N - 2);
    }

}
