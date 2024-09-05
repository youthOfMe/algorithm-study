package com.yang.dachang.timet24t09.time04;

/**
 * 汉诺塔问题V2
 */
public class Code04 {

    public static void main(String[] args) {
        fromToTarget(3, "Left", "Right", "Middle");
    }

    public static void fromToTarget(int n, String from, String target, String other) {
        if (n == 1) {
            System.out.println("Move 1 From " + from + " To " + target);
            return;
        }
        fromToTarget(n - 1, from, other, target);
        System.out.println("Move " + n + " From " + from + " To " + target);
        fromToTarget(n - 1, other, target, from);
    }
}
