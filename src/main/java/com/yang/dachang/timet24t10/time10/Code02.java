package com.yang.dachang.timet24t10.time10;

/**
 * 复习manacher算法
 */
public class Code02 {

    public static int getTarget(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        final int N = str.length();
        char[] chars = strToManacherStr(str);
        int[] parr = new int[N];
        int center = 0;
        int right = -1;
        int index = 0;
        int max = -1;
        while (index < N) {
            parr[index] = right > index ? Math.min(2 * center - right, right - index) : 1;
            while (index + parr[index] < N && index - parr[index] > -1) {
                if (chars[index + parr[index]] == chars[index - parr[index]]) {
                    parr[index]++;
                } else {
                    break;
                }
            }
            if (parr[index] > right) {
                center = index;
                right = parr[index];
            }
            max = Math.max(max, parr[index]);
            index++;
        }
        return max;
    }

    public static char[] strToManacherStr(String str) {
        char[] chars = str.toCharArray();
        final int N = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < N; index++) {
            stringBuilder.append("#").append(chars[index]);
        }
        stringBuilder.append("#");
        return stringBuilder.toString().toCharArray();
    }

}
