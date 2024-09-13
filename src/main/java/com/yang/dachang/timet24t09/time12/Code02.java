package com.yang.dachang.timet24t09.time12;

/**
 * 数字字符串转换问题
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(String target) {
        if (target == null || target.isEmpty()) return 0;
        final int N = target.length();
        int[] ints = new int[N + 2];
        char[] chars = target.toCharArray();
        int ways = 0;
        ints[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                ways += ints[i + 1];
                if ((chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
                    ways += ints[i + 2];
                }
            }
        }
        return ways;
    }


}
