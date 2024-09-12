package com.yang.dachang.timet24t09.time11;

/**
 * 剪纸问题-暴力递归
 */
public class Code01 {

    public static void main(String[] args) {

    }

    // public static int getTarget(String target, String[] strings) {
    //     if (target == null || target.isEmpty() || strings == null || strings.length == 0) return 0;
    //
    // }

    public static int process(String target, String[] strings) {
        if (target.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for (String string : strings) {
            String newTarget = minus(target, string);
            if (newTarget.length() != target.length()) {
                min = Math.min(process(newTarget, strings), min);
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(String target, String item) {
        char[] targetArr = target.toCharArray();
        char[] itemArr = item.toCharArray();
        int[] count = new int[26];
        for (char cha : targetArr) {
            count[cha - 'a']++;
        }
        for (char cha : itemArr) {
            count[cha - 'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                stringBuilder.append(i + 'a');
            }
        }
        return stringBuilder.toString();
    }

}
