package com.yang.dachang.timet24t10.time12;

/**
 * KMP算法
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return -1;
        }
        final int len1 = str1.length();
        final int len2 = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
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
        return (y == len2) ? x - len2 : -1;
    }

    public static int[] getNextArr(char[] chars) {
        final int N = chars.length;
        int[] next = new int[N];
        int index = 2;
        int cur = 0;
        next[0] = -1;
        next[1] = 0;
        while (index < N) {
            if (chars[index - 1] == chars[cur]) {
                next[index++] = ++cur;
            } else if (next[cur] != -1) {
                cur = next[cur];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

}
