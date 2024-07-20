package com.yang.dachang.timet24t7t16;

public class Code05 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 6, 6, 6, 8, 8, 8, 88, 88, 66, 66};

        getTarget(arr);
    }

    public static void getTarget(int[] arr) {
        int err = 0;

        for (int item : arr) {
            err = err ^ item;
        }

        // 得到err最右侧的1
        int rightOne = err & (~err + 1);
        // 引入err1
        int err1 = 0;
        for (int item : arr) {
            // 有1的数
            if ((item & rightOne) != 0) {
                // 得到a
                err1 = err1 ^ item;
            }
        }
        // 得到b
        err = err ^ err1;
        System.out.println(err);
        System.out.println(err1);
    }
}
