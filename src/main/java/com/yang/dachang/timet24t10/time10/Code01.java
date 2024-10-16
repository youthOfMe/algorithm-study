package com.yang.dachang.timet24t10.time10;

import com.yang.dachang.timet24t08t08.IndexHeap;

/**
 * KMP算法
 */
public class Code01 {

    public static int getTarget(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return 0;
        }
        final int len1 = str1.length();
        final int len2 = str2.length();
        final char[] chars1 = str1.toCharArray();
        final char[] chars2 = str2.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArr(chars2);
        while (x < len1 && y < len2) {
            if (chars1[x] == chars2[y]) {
                x++;
                y++;
            } else if (next[y] != -1) {
                y = next[y];
            } else {
                x++;
            }
        }
        return y == len2 ? (x - y) : -1;
    }

    public static int[] getNextArr(char[] chars) {
        final int N = chars.length;
        int[] next = new int[N];
        next[0] = -1;
        next[1] = 0;
        int up = 0;
        int cur = 2;
        while (cur < N) {
            if (chars[cur - 1] == chars[up]) {
                next[cur++] = ++up;
            } else if (next[up] != -1) {
                up = next[up];
            } else {
                next[cur++] = 0;
            }
        }
        return next;
    }

}
