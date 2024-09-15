package com.yang.dachang.timet24t09.time14;

/**
 * 求字符串的最长回文子序列的长度 => 暴力递归
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(String target) {
        if (target == null || target.isEmpty()) return 0;
        String revTar = new StringBuilder(target).reverse().toString();
        return process(target.toCharArray(), target.length() - 1, revTar.toCharArray(), revTar.length() - 1);
    }

    public static int process(char[] target, int i, char[] revTar, int j) {
        if (i == 0 && j == 0) return target[i] == revTar[i] ? 1 : 0;
        if (i == 0) {
            if (target[0] == revTar[j]) {
                return 1;
            } else {
                return process(target, i, revTar, j - 1);
            }
        } else if (j == 0) {
            if (target[i] == revTar[0]) {
                return 1;
            } else {
                return process(target, 1, revTar, j - 1);
            }
        } else {
            int p1 = process(target, i, revTar, j - 1);
            int p2 = process(target, i - 1, revTar, j);
            int p3 = target[i] == revTar[j] ? process(target, i, revTar, j) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

}
