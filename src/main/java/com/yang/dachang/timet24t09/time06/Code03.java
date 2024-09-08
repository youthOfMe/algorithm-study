package com.yang.dachang.timet24t09.time06;

/**
 * 机器人次数问题
 */
public class Code03 {

    public static void main(String[] args) {
        System.out.println(getTarget(4, 2, 4, 4));
    }

    public static int getTarget(int N, int start, int aim, int k) {
        return process1(start, k, aim ,N);
    }

    public static int process1(int cur, int rest, int aim, int N) {
        // 走完了记录一下
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process1(cur + 1, rest - 1, aim, N);
        }
        if (cur == N) {
            return process1(cur - 1, rest - 1, aim, N);
        }
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

}
