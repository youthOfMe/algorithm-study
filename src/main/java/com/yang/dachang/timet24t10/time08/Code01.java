package com.yang.dachang.timet24t10.time08;

import java.util.Queue;

/**
 * KMP算法
 */
public class Code01 {

    public static void main(String[] args) {
        String str1 = "aaa123";
        String str2 = "123";
        System.out.println(getTarget(str1, str2));
    }

    public static int getTarget(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return -1;
        }
        final int len1 = str1.length();
        final int len2 = str2.length();
        if (len2 > len1) return -1;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length == 1) {
            return chars1[0] == chars2[0] ? 0 : -1;
        }
        int[] next = getNextArr(chars2);
        int x = 0;
        int y = 0;
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
        int index = 2;
        int cur = 0;
        while (index < N) {
            if (chars[index] == chars[cur]) {
                next[index++] = ++cur;
            } else if (next[cur] != -1) {
                cur = next[cur];
            } else {
                next[index++] = -1;
            }
        }
        return next;
    }

}
