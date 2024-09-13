package com.yang.dachang.timet24t09.time12;

/**
 * 求两字符串最长公共子序列
 */
public class Code04 {

    public static void main(String[] args) {

    }

    public static int getTarget(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) return 0;
        return process(str1.toCharArray(), str1.length() - 1, str2.toCharArray(), str2.length() - 1);
    }

    public static int process(char[] str1, int i, char[] str2, int j) {
        if (i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        } else if (i == 0) {
            if (str1[0] == str2[j]) {
                return 1;
            } else {
                return process(str1, 0, str2, j - 1);
            }
        } else if (j == 0) {
            if (str1[i] == str2[0]) {
                return 1;
            } else {
                return process(str1, i - 1, str2, 0);
            }
        } else {
            int p1 = process(str1, i - 1, str2, j);
            int p2 = process(str2, i, str2, j - 1);
            int p3 = str1[i] == str2[j] ? (1 + process(str1, i - 1, str2, j - 1)) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

}
