package com.yang.dachang.timet24t08t17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心解决最多安排会议问题
 */
public class Code01 {

    public static void main(String[] args) {

        ArrayList<Program> list = new ArrayList<>();
        Program program1 = new Program(1, 5);
        list.add(program1);
        Program program2 = new Program(1, 2);
        list.add(program2);
        Program program3 = new Program(2, 8);
        list.add(program3);
        Program program4 = new Program(3, 6);
        list.add(program4);
        Program program5 = new Program(3, 11);
        list.add(program5);
        int result = getResult(list.toArray(new Program[list.size()]));
        System.out.println(result);
        System.out.println(getResult(list.toArray(new Program[list.size()])));
    }

    public static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int getResult(Program[] programs) {
        if (programs.length < 1) {
            return 0;
        }
        return process(programs, 0, 0);
    }

    public static int process(Program[] programs, int done, int timeline) {
        if (programs.length < 1) {
            return 0;
        }
        int max = done;
        for (int i = 0; i < programs.length; i++) {
            Program curProgram = programs[i];
            if (curProgram.start >= timeline) {
                Program[] nextArr = removeiGetArr(programs, i);
                max = Math.max(process(nextArr, done + 1, curProgram.end), max);
            }
        }
        return max;
    }

    public static Program[] removeiGetArr(Program[] programs, int i) {
        int addIndex = 0;
        int N = programs.length;
        Program[] resArr = new Program[N - 1];
        for (int j = 0; j < N; j++) {
            if (j != i) {
                resArr[addIndex++] = programs[j];
            }
        }
        return programs;
    }

    // 贪心解决
    public static class CompareTimeLine implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int getTarget(Program[] programs) {
        Arrays.sort(programs, new CompareTimeLine());
        int res = 1;
        Program preProgram = programs[0];
        for (int i = 1; i < programs.length; i++) {
            Program curProgram = programs[i];
            if (preProgram.end <= curProgram.start) {
                res++;
            }
        }
        return res;
    }
}
