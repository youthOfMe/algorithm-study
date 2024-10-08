package com.yang.dachang.timet24t10.time03;

import java.util.Stack;

/**
 * 有一个二维矩阵，1可以组合为矩阵，问矩阵最大面积
 */
public class Code01 {

    public static void main(String[] args) {
        // System.out.println(getTarget2(strArrToCharArr(new String[]{"01101","11010","01110","11110","11111","00000"})));
        // System.out.println(getTarget3(strArrToCharArr(new String[]{"01101","11010","01110","11110","11111","00000"})));
        testFun(1000, 20, 20);
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
    public static int getTarget(char[][] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int max = 0;
        final int N = arr.length;
        final int M = arr[0].length;
        Stack<Integer> stack = new Stack<>();
        int[] rowArr = new int[M];
        for (int row = 0; row < N; row++) {

            for (int col = 0; col < M; col++) {
                rowArr[col] = (arr[row][col] - '0') + (row > 0 && (arr[row][col] - '0' != 0)  ? rowArr[col] : 0);
            }

            int index = 0;
            stack.push(index++);

            while (index < M) {
                int cur = stack.peek();
                while (cur != -1 && rowArr[index] <= rowArr[cur]) {
                    stack.pop();
                    int next = stack.isEmpty() ? 0 : stack.peek() + 1;
                    max = Math.max(max, rowArr[cur] * (index - next));
                    cur = stack.isEmpty() ? -1 : stack.peek();
                }

                while (index < M && (cur == -1 || rowArr[index] > rowArr[cur])) {
                    stack.push(index++);
                    cur = stack.peek();
                }
            }

            while (!stack.isEmpty()) {
                int cur = stack.pop();
                int next = stack.isEmpty() ? 0 : stack.peek() + 1;
                max = Math.max(max, rowArr[cur] * (M - next));
            }
        }

        return max;
    }

    // 非系统栈优化O(M * N)
    public static int getTarget2(char[][] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int max = 0;
        final int N = arr.length;
        final int M = arr[0].length;
        int[] stack = new int[M];
        int point = -1;
        // Stack<Integer> stack = new Stack<>();
        int[] rowArr = new int[M];
        for (int row = 0; row < N; row++) {

            int index = 0;
            stack[++point] = index++;

            for (int col = 0; col < M; col++) {
                rowArr[col] = (arr[row][col] - '0') + (row > 0 && (arr[row][col] - '0' != 0)  ? rowArr[col] : 0);
            }

            while (index < M) {
                int cur = stack[point];
                while (cur != -1 && rowArr[index] <= rowArr[cur]) {
                    point--;
                    int next = point == -1 ? 0 : stack[point] + 1;
                    max = Math.max(max, rowArr[cur] * (index - next));
                    cur = point == -1 ? -1 : stack[point];
                }

                while (index < M && (cur == -1 || rowArr[index] > rowArr[cur])) {
                    stack[++point] = index++;
                    cur = stack[point];
                }
            }

            while (point != -1) {
                int cur = stack[point--];
                int next = point == -1 ? 0 : stack[point] + 1;
                max = Math.max(max, rowArr[cur] * (M - next));
            }
        }

        return max;
    }

    // 暴力解O(M3 * N3)
    public static int getTarget3(char[][] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int max = 0;
        final int N = arr.length;
        final int M = arr[0].length;
        int aRow = 0;
        while (aRow < N) {
            int aCol = 0;
            while (aCol < M) {
                int bRow = 0;
                while (bRow < N) {
                    int bCol = 0;
                    while (bCol < M) {
                        int count = 0;
                        for (int y = aRow; y <= bRow; y++) {
                            for (int x = aCol; x <= bCol; x++) {
                                if (arr[y][x] == '0') {
                                    count = -1;
                                    break;
                                }
                                count++;
                            }
                            if (count == -1) {
                                break;
                            }
                        }
                        max = Math.max(max, count);
                        bCol++;
                    }
                    bRow++;
                }
                aCol++;
            }
            aRow++;
        }
        return max;
    }

    // 对数器 k -> 多少次, row 行 -> 最大row, col 列 -> 最大col
    public static void testFun(int k, int row, int col) {
        for (int i = 0; i < k; i++) {
            String[] strings = randomStrArr(row, col);
            int target = getTarget2(strArrToCharArr(strings));
            int target2 = getTarget3(strArrToCharArr(strings));
            if (target != target2) {
                System.out.println("出错了");
            }
        }
    }

    public static String[] randomStrArr(int row, int col) {
        StringBuilder stringBuilder = null;
        final int N = (int) (Math.random() * (row + 1));
        final int M = (int) (Math.random() * col) + 1;
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            stringBuilder = new StringBuilder();
            for (int j = 0; j < M; j++) {
                int num = (int) (Math.random() * 2);
                stringBuilder.append((char) (num + '0'));
            }
            arr[i] = stringBuilder.toString();
        }
        return arr;
    }

}
