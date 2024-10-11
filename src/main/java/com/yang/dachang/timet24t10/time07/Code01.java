package com.yang.dachang.timet24t10.time07;

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
        if (len1 < len2) return -1;
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArr(charStr2);
        while (x < len1 && y < len2) {
            if (charStr1[x] == charStr2[y]) {
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

    public static int[] getNextArr(char[] arr) {
        final int N = arr.length;
        int[] res = new int[N];
        res[0] = -1;
        res[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < N) {
            if (arr[cn] == arr[index - 1]) {
                res[index++] = ++cn;
            } else if (cn > 0) {
                cn = res[cn];
            } else {
                res[index++] = 0;
            }
        }
        return res;
    }

}
