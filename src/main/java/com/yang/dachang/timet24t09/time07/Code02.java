package com.yang.dachang.timet24t09.time07;

/**
 * 斐波那契数列
 */
public class Code02 {

    public static void main(String[] args) {
        System.out.println(getTarget(6));
    }

    public static int getTarget(int N) {
        int[] cache = new int[N + 1];
        return process(N, cache);
    }

    public static int process(int N, int[] cache) {
        if (N == 1 || N == 2) return 1;
        if (cache[N] != 0) return cache[N];
        int ans = 0;
        ans = process(N - 1, cache) + process(N - 2, cache);
        cache[N] = ans;
        return ans;
    }

}
