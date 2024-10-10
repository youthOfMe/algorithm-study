package com.yang.dachang.timet24t10.time06;

/**
 * 乞丐版KMP算法 -> 求next数组慢
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(String str1, String str2) {
        if (str1 == null || str2 == null) return -1;
        final int len1 = str1.length();
        final int len2 = str2.length();
        if (len1 < len2) return -1;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] nextArr = getNextArr(chars2);
        int x = 0;
        int y = 0;
        while (x < len1 && y < len2) {
            if (chars1[x] == chars2[y]) {
                x++;
                y++;
            } else if (nextArr[y] == -1) {
                y++;
            } else {
                y = nextArr[y];
            }
        }
        return y == len2 ? (x - y) : -1;
    }

    public static int[] getNextArr(char[] strChars) {
        return new int[]{};
    }

}
