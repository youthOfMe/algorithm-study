package com.yang.dachang.timet24t10.time03;

import java.util.Stack;

/**
 * 有一个二维矩阵，1可以组合为矩阵，求有多少个矩阵
 */
public class Code02 {

    public static void main(String[] args) {
        // System.out.println(getTarget(strArrToCharArr(new String[]{"01101","11010","01110","11110","11111","00000"})));
        System.out.println(getTarget(new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        }));
        System.out.println(getTarget2(new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        }));
        // [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
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
                        res += num * (len * (len + 1) >> 1);
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
                res += num * (len * (len + 1) >> 1);
            }
        }
        return res;
    }

    // 使用非系统栈优化O(M * N)
    public static int getTarget2(int[][] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        final int N = arr.length;
        final int M = arr[0].length;
        int point = -1;
        int res = 0;
        int[] stack = new int[M];
        int[] rowArr = new int[M];
        for (int row = 0; row < N; row++) {
            int index = 0;
            stack[++point] = index++;

            for (int col = 0; col < M; col++) {
                rowArr[col] = arr[row][col] + (row > 0 && arr[row][col] != 0 ? rowArr[col] : 0);
            }

            while (index < M) {
                int cur = stack[point];
                while (cur != -1 && rowArr[cur] >= rowArr[index]) {
                    point--;
                    if (rowArr[cur] != rowArr[index]) {
                        int left = point != -1 ? stack[point] : -1;
                        int right = index;
                        int len = right - left -1;
                        int num = rowArr[cur] - Math.max(left != -1 ? rowArr[left] : 0, rowArr[right]);
                        res += num * (len * (len + 1) >> 1);
                    }
                    cur = point != -1 ? stack[point] : -1;
                }

                while (index < M && (cur == -1 || rowArr[cur] < rowArr[index])) {
                    cur = index;
                    stack[++point] = index++;
                }
            }

            while (point != -1) {
                int cur = stack[point--];
                int left = point != -1 ? stack[point] : -1;
                int right = M;
                int len = right - left - 1;
                int num = rowArr[cur] - (left != -1 ? rowArr[left] : 0);
                res += num * (len * (len + 1) >> 1);
            }
        }
        return res;
    }

}
