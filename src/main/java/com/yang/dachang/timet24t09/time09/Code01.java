package com.yang.dachang.timet24t09.time09;

/**
 * 机器人问题（暴力递归）
 */
public class Code01 {

    public static void main(String[] args) {
        System.out.println(getTarget1(5, 2, 4, 6));
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



}
