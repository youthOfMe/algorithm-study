package com.yang.dachang.oneday;

// 位运算交换两数的值
public class Code02 {

    public static void main(String[] args) {
        swap(10, 12);
    }

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
