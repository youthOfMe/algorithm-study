package com.yang.dachang.timet24t09.time10;

/**
 * 字符串转化问题
 */
public class Code06 {

    public static void main(String[] args) {
        System.out.println(getTarget("123"));
    }

    public static int getTarget(String str) {
        if (str == null || str.isEmpty()) return 0;
        return process(str.toCharArray(), 0);
    }

    public static int process(char[] chars, int index) {
        if (index == chars.length) return 1;
        if (chars[index] == '0') return 0;

        int ways = process(chars, index + 1);
        if ((chars[index] - '0') * 10 + chars[index] - '0' < 27) {
            ways += process(chars, index + 2);
        }
        return ways;
    }

}
