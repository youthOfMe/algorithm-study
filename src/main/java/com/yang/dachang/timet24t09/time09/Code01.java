package com.yang.dachang.timet24t09.time09;

import java.util.Arrays;

/**
 * 机器人问题（暴力递归）
 */
public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget3(5, 2, 4, 6));
    }

    public static int getTarget1(int N, int start, int aim, int k) {
        return process1(N, start, aim, k);
    }

    public static int process1(int N, int cur, int aim, int rest) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process1(N, cur + 1, aim, rest - 1);
        }
        if (cur == N) {
            return process1(N, cur - 1, aim, rest - 1);
        }
        return process1(N, cur + 1, aim, rest - 1) + process1(N, cur - 1, aim, rest - 1);
    }

    public static int getTarget2(int N, int start, int aim, int rest) {
        int[][] cache = new int[N + 1][rest + 1];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return process2(N, start, aim, rest, cache);
    }

    public static int process2(int N, int cur, int aim, int rest, int[][] cache) {
        if (cache[cur][rest] != -1) {
            return cache[cur][rest];
        }
        int res = -1;
        if (rest == 0) {
            res = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            res = process2(N, cur + 1, aim, rest - 1, cache);
        } else if (cur == N) {
            res = process2(N, cur - 1, aim, rest - 1, cache);
        } else {
            res = process1(N, cur + 1, aim, rest - 1) + process1(N, cur - 1, aim, rest - 1);
        }
        return res;
    }

    public static int getTarget3(int N, int start, int aim, int rest) {
        int[][] ints = new int[N + 1][rest + 1];
        ints[aim][0] = 1;
        for (int r = 1; r < rest; r++) {
            ints[1][r] = ints[2][r - 1];
            for (int cur = 2; cur < N; cur++) {
                ints[cur][r] = ints[cur - 1][r - 1] + ints[cur + 1][r - 1];
            }
            ints[N][r] = ints[N - 1][r - 1];
        }
        return ints[start][rest];
    }

}
