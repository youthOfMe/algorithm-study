package com.yang.dachang.timet24t10.time03;

import java.util.Stack;

/**
 * 有一个二维矩阵，1可以组合为矩阵，求有多少个矩阵
 */
public class Code02 {

    public static void main(String[] args) {
        // System.out.println(getTarget(strArrToCharArr(new String[]{"01101","11010","01110","11110","11111","00000"})));
        System.out.println(getTarget(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    public static char[][] strArrToCharArr(String[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        final int N = arr.length;
        final int M = arr[0].length();
        char[][] chars = new char[N][M];
        for (int i = 0; i < N; i++) {
            chars[i] = arr[i].toCharArray();
        }
        return chars;
    }

    // 系统栈O(M * N)
    public static int getTarget(int[][] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int res = 0;
        final int N = arr.length;
        final int M = arr[0].length;
        int[] rowArr = new int[M];
        Stack<Integer> stack = new Stack<>();
        for (int row = 0; row < N; row++) {

            for (int col = 0; col < M; col++) {
                rowArr[col] = arr[row][col] + (row > 0 && arr[row][col] != 0 ? rowArr[col] : 0);
            }

            int index = 0;
            stack.push(index++);

            while (index < M) {
                int cur = stack.peek();
                while (cur != -1 && rowArr[cur] >= rowArr[index]) {
                    stack.pop();
                    if (rowArr[index] != rowArr[cur]) {
                        int left = stack.isEmpty() ? -1 : stack.peek();
                        int right = index;
                        int len = right - left - 1;
                        int num = rowArr[cur] - Math.max(left == -1 ? 0 : rowArr[left], rowArr[right]);
                        res += num * (len * (len + 1) / 2);
                    }
                    cur = stack.isEmpty() ? -1 : stack.peek();
                }

                while (index < M && (cur == -1 || rowArr[cur] < rowArr[index])) {
                    cur = index;
                    stack.push(index++);
                }
            }

            while (!stack.isEmpty()) {
                int cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = M;
                int len = right - left - 1;
                int num = rowArr[cur] - (left == -1 ? 0 : rowArr[left]);
                res += num * (len * (len + 1) / 2);
            }
        }
        return res;
    }

}
