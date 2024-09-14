package com.yang.dachang.timet24t09.time13;

/**
 * 剪纸问题暴力
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(String target, String[] strings) {
        if (target == null || target.isEmpty() || strings == null || strings.length == 0) {
            return 0;
        }
        return process(target, strings);
    }

    public static int process(String target, String[] strings) {
        if (target.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            String tar = minus(target.toCharArray(), strings[i].toCharArray());
            if (target.length() != tar.length()) {
                min = Math.min(min, process(tar, strings));
            }
        }
        return min + ((min != Integer.MAX_VALUE) ? 1 : 0);
    }

    public static String minus(char[] target, char[] str) {
        int[] ints = new int[26];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length; i++) {
            ints[target[i] - 'a']++;
        }
        for (int i = 0; i < str.length; i++) {
            ints[target[i] - 'a']--;
        }
        for (int i = 0; i < ints.length; i++) {
            res.append((char) ints[i] + 'a');
        }
        return res.toString();
    }

}
