package com.yang.dachang.timet24t7t16;

public class Code01 {

    public static void print(int num) {
        String s = "";
        for (int i = 31; i >= 0; i--) {
            s += (num & (1 << i)) == 0 ? "0" : "1";
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        // 32位
        int num = 3;

        print(num);
    }
}
