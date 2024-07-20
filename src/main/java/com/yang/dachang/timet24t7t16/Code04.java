package com.yang.dachang.timet24t7t16;

public class Code04 {
    public static void main(String[] args) {
        int target = 56;

        target = target & (~target + 1);
        System.out.println(target);

    }
}
