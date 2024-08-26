package com.yang.dachang.timet24t08t26;

/**
 * 韩罗塔问题基础版本
 */
public class Code01 {

    public static void main(String[] args) {
        hanoti(3);
    }

    public static void hanoti(int n) {
        leftToRight(n);
    }

    public static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from Left To Right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("Move " + n + "  from left to right");
        midToRight(n - 1);
    }


    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from Left To mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from Right To mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from Right To Left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("Move " + n + " from right To Left");
        midToLeft(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from Mid To Left");
            return;
        }
        midToRight(n - 1);
        System.out.println("Move " + n + " from mid To Left");
        rightToMid(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from Mid To Right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("Move " + n + " from mid To Left");
        leftToRight(n - 1);
    }


}
