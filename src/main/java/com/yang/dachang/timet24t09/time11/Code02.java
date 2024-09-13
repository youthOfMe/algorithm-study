package com.yang.dachang.timet24t09.time11;

/**
 * 剪纸问题
 */
public class Code02 {

    public static void main(String[] args) {

    }

    // public static int getTarget(String target, String[] strings) {
    //
    // }

    public static int process(String target, String[] strings) {
        if (target.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for (String string : strings) {
            String minus = minus(target, string);
            if (minus.length() == target.length()) {
                min = Math.min(min, process(target, strings));
            }
        }


        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(String target, String item) {
        char[] tarArr = target.toCharArray();
        char[] itemArr = item.toCharArray();
        int[] count = new int[26];
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : tarArr) {
            count[c - 'a']++;
        }
        for (char c : itemArr) {
            count[c - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                stringBuilder.append(i + 'a');
            }
        }
        return stringBuilder.toString();
    }

}
