package com.yang.dachang.timet24t10.time08;

/**
 * manacher算法 -> 求最长回文子序列的长度
 */
public class Code03 {

    public static void main(String[] args) {
        System.out.println(getTarget("123321"));
    }

    public static int getTarget(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int right = -1;
        int index = 0;
        int center = -1;
        char[] chars = strToManacherStr(str);
        final int N = chars.length;
        int[] parr = new int[N];
        while (index < N) {
            parr[index] = right > index ? Math.min(parr[2 * center - index], right - index) : 1;
            while (index + parr[index] < N && index - parr[index] > -1) {
                if (chars[index + parr[index]] == chars[index - parr[index]]) {
                    parr[index]++;
                } else {
                    break;
                }
            }
            if (right < index + parr[index]) {
                right = index + parr[index];
                center = index;
            }
            max = Math.max(max, parr[index]);
            index++;
        }
        return max - 1;
    }

    public static char[] strToManacherStr(String str) {
        final int N = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (char item : str.toCharArray()) {
            stringBuilder.append("#").append(item);
        }
        stringBuilder.append("#");
        return stringBuilder.toString().toCharArray();
    }

}
