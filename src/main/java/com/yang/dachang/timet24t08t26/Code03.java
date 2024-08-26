package com.yang.dachang.timet24t08t26;

/**
 * 韩罗塔V2
 */
public class Code03 {

    public static void main(String[] args) {
        hanoi1(3);
    }

    public static void hanoi1(int n) {
        fromToTo(n, "left", "right", "mid");
    }

    private static void fromToTo(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 From " + from + " To " + to);
            return;
        }
        fromToTo(n - 1, from, other, to);
        System.out.println("Move " + n + " From " + from + " To " + to);
        fromToTo(n - 1, other, to, from);
    }

}