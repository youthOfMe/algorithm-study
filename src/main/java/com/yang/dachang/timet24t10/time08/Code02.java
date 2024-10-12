package com.yang.dachang.timet24t10.time08;

/**
 * manacher算法 -> 求最长回文子序列的长度
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        char[] chars = strToManacherStr(str);
        final int N = chars.length;
        int index = 0;
        int right = -1;
        int center = 0;
        int[] pArr = new int[N];
        while (index < N) {
            pArr[index] = right > index ? Math.min(2 * center - index, right - index) : 1;
            while (index + pArr[index] < N && index - pArr[index] > -1) {
                if (chars[index + pArr[index]] == chars[index - pArr[index]]) {
                    pArr[index]++;
                } else {
                    break;
                }
            }
            if (index + pArr[index] > right) {
                right = index + pArr[index];
                center = index;
            }
            max = Math.max(max, pArr[index]);
            index++;
        }
        return max - 1;
    }

    public static char[] strToManacherStr(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char item : chars) {
            stringBuilder.append("#").append(item);
        }
        stringBuilder.append("#");
        return stringBuilder.toString().toCharArray();
    }


}
