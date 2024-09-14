package com.yang.dachang.timet24t09.time13;

/**
 * 剪纸问题 - 优化版本V1
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(String target, String[] strings) {
        if (target == null || target.isEmpty() || strings == null || strings.length == 0) {
            return 0;
        }
        final int N = strings.length;
        int[][] stickArr = new int[N][26];
        for (int i = 0; i < N; i++) {
            for (char c : strings[i].toCharArray()) {
                stickArr[i][c - 'a']++;
            }
        }
    }

    public static int process(String target, int[][] stickArr) {
        if (target.isEmpty()) {
            return 0;
        }
        char[] chars = target.toCharArray();
        int[] counts = new int[26];
        for (char aChar : chars) {
            counts[aChar - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] ints : stickArr) {
            // 剪枝优化
            if (ints[counts[0] - 'a'] > 0) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] > 0) {
                        int nums = counts[i] - ints[i];
                        for (int j = 0; j < nums; j++) {
                            res.append((char) j + 'a');
                        }
                    }
                }
                String rest = res.toString();
                min = Math.min(min, process(rest, stickArr));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

}
