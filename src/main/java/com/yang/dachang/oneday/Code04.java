package com.yang.dachang.oneday;

public class Code04 {
    public static void main(String[] args) {
        int target = 56;

        target = target & (~target + 1);
        System.out.println(target);

    }
}
