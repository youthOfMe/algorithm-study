package com.yang.dachang.timet24t08t26;

/**
 * 韩罗塔问题基础版本
 */
public class Code02 {

    public static void main(String[] args) {
        hanoi1(2);
    }

    public static void hanoi1(int n) {
        leftToRight(n);
    }

    private static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 From left To Right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("Move " + n + " From left To Right");
        midToRight(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 From left To Mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move " + n + " From left To Mid");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 From right To Mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("Move " + n + " From right To Mid");
        leftToMid(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 From right To Left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("Move " + n + " From right To Left");
        midToLeft(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 From mid To Left");
            return;
        }
        midToRight(n - 1);
        System.out.println("Move " + n + " From mid To Left");
        rightToLeft(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 From mid To Right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("Move " + n + " From mid To Right");
        leftToRight(n - 1);
    }
}
