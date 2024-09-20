package com.yang.dachang.timet24t09.time19;

/**
 * 怪兽会死的概率 - 暴力递归
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static double getTarget(int hp, int M, int times) {
        return (double) process(hp, M, times) / Math.pow(M + 1, times);
    }

    public static long process(int hp, int M, int rest) {
        if (rest <= 0) {
            return hp <= 0 ? 1 : 0;
        }
        if (hp <= 0) {
            return (long) Math.pow(M + 1, rest);
        }
        long ways = 0;
        for (int i = 0; i <= M; i++) {
            ways += process(hp - i, M, rest - 1);
        }
        return ways;
    }

}
