package com.yang.dachang.timet24t09.time05;

/**
 * 斐波那契额数列（纯暴力）
 */
public class Code06 {

    public static void main(String[] args) {
        System.out.println(getTarget(3));
    }

    public static int getTarget(int n) {
        if (n == 1 || n == 2) return 1;
        return getTarget(n - 1) + getTarget(n - 2);
    }

}
