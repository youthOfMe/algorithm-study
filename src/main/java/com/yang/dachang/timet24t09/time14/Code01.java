package com.yang.dachang.timet24t09.time14;

import java.util.HashMap;
import java.util.Map;

/**
 * 剪纸问题动态规划
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget3(String target, String[] sticks) {
        if (target == null || target.isEmpty() || sticks == null || sticks.length == 0) return 0;
        final int N = sticks.length;
        int[][] charSet = new int[N][26];
        for (int i = 0; i < sticks.length; i++) {
            for (char c : sticks[i].toCharArray()) {
                charSet[i][c - 'a']++;
            }
        }
        Map<String, Integer> cache = new HashMap<>();
        return process3(target, charSet, cache);
    }

    public static int process3(String target, int[][] charSet, Map<String, Integer> cache) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        if (target.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] tarCharSet = new int[26];
        char[] tarChars = target.toCharArray();
        int count = tarChars[0] - 'a';
        for (char c : tarChars) {
            tarCharSet[c - 'a']++;
        }
        for (int[] ints : charSet) {
            if (ints[count] > 0) {
                StringBuilder res = new StringBuilder();
                for (int cha : ints) {
                    tarCharSet[cha - 'a']--;
                }
                for (int i = 0; i < tarCharSet.length; i++) {
                    if (tarCharSet[i] > 0) {
                        res.append((char) i + 'a');
                    }
                }
                min = process2(res.toString(), charSet);
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1)
        cache.put(target, ans);
        return ans;
    }

    public static int getTarget2(String target, String[] sticks) {
        if (target == null || target.isEmpty() || sticks == null || sticks.length == 0) return 0;
        final int N = sticks.length;
        int[][] charSet = new int[N][26];
        for (int i = 0; i < sticks.length; i++) {
            for (char c : sticks[i].toCharArray()) {
                charSet[i][c - 'a']++;
            }
        }
        return process2(target, charSet);
    }

    public static int process2(String target, int[][] charSet) {
        if (target.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] tarCharSet = new int[26];
        char[] tarChars = target.toCharArray();
        int count = tarChars[0] - 'a';
        for (char c : tarChars) {
            tarCharSet[c - 'a']++;
        }
        for (int[] ints : charSet) {
            if (ints[count] > 0) {
                StringBuilder res = new StringBuilder();
                for (int cha : ints) {
                    tarCharSet[cha - 'a']--;
                }
                for (int i = 0; i < tarCharSet.length; i++) {
                    if (tarCharSet[i] > 0) {
                        res.append((char) i + 'a');
                    }
                }
                min = process2(res.toString(), charSet);
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static int getTarget(String target, String[] sticks) {
        if (target == null || target.isEmpty() || sticks == null || sticks.length == 0) return 0;
        return process(target, sticks);
    }


    public static int process(String target, String[] sticks) {
        if (target.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sticks.length; i++) {
            String rest = minus(target.toCharArray(), sticks[i].toCharArray());
            if (rest.length() != target.length()) {
                min = Math.min(min, process(rest, sticks));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(char[] target, char[] yuTong) {
        int[] ints = new int[26];
        StringBuilder res = new StringBuilder();
        for (char c : target) {
            ints[c - 'a']++;
        }
        for (char c : yuTong) {
            ints[c - 'a']--;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                res.append((char) i + 'a');
            }
        }
        return res.toString();
    }

}
