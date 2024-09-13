package com.yang.dachang.timet24t09.time12;

/**
 * 剪纸问题
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(String target, String[] strings) {
        if (target == null || target.isEmpty() || strings == null || strings.length == 0) return 0;
        return process(target, strings);
    }

    public static int process(String target, String[] strings) {
        if (target.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            String newStr = minus(target.toCharArray(), strings[i].toCharArray());
            if (newStr.length() != target.length()) {
                min = Math.min(min, process(newStr, strings));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(char[] target, char[] key) {
        StringBuilder res = new StringBuilder();
        int[] ints = new int[26];
        for (int i = 0; i < target.length; i++) {
            ints[target[i] - 'a']++;
        }
        for (int i = 0; i < key.length; i++) {
            ints[key[i] - 'a']--;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                res.append((char) i + 'a');
            }
        }
        return res.toString();
    }

}
