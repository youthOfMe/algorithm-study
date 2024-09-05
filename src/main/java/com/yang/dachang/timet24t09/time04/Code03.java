package com.yang.dachang.timet24t09.time04;

/**
 * 汉诺塔问题（V1）
 */
public class Code03 {

    public static void main(String[] args) {
        leftToRight(3);
    }

    public static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 From Left To Right");
            return;
        }
        leftToMiddle(n - 1);
        System.out.println("Move " + n + " From Left To Right");
        middleToRight(n - 1);
    }

    private static void leftToMiddle(int n) {
        if (n == 1) {
            System.out.println("Move 1 From Left To Middle");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move " + n + " From Left To Middle");
        rightToMiddle(n - 1);
    }

    private static void rightToMiddle(int n) {
        if (n == 1) {
            System.out.println("Move 1 From Right To Middle");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("Move " + n + " From Right To Middle");
        leftToMiddle(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 From Right To Left");
            return;
        }
        rightToMiddle(n - 1);
        System.out.println("Move " + n + " From Right To Left");
        middleToLeft(n - 1);
    }

    private static void middleToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 From Middle To Right");
            return;
        }
        middleToLeft(n - 1);
        System.out.println("Move " + n + " From Middle To Right");
        leftToRight(n - 1);
    }

    private static void middleToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 From Middle To Left");
            return;
        }
        middleToRight(n - 1);
        System.out.println("Move " + n + " From Middle To Left");
        rightToLeft(n - 1);
    }

}
