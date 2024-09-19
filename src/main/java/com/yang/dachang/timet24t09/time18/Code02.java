package com.yang.dachang.timet24t09.time18;

/**
 * 怪兽会死的概率 -> 暴力帝国
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static double getTarget(int hp, int times, int M) {
        return (double) process(hp, times, M) / (double) Math.pow(M + 1, times);
    }

    public static long process(int hp, int times, int M) {
        if (times == 0) {
            return hp <= 0 ? 1 : 0;
        }
        if (hp <= 0) {
            return (long) Math.pow(M + 1, times);
        }
        long ways = 0;
        for (int time = 0; time <= times; time++) {
            ways += process(hp - time, times - 1, M);
        }
        return ways;
    }

}
