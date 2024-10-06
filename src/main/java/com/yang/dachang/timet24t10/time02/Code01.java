package com.yang.dachang.timet24t10.time02;

import java.util.Arrays;
import java.util.Stack;

/**
 * 有一个二维矩阵，1可以组合为矩阵，问矩阵最大面积
 */
public class Code01 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        int target = getTarget(arr);
        System.out.println(target);

        System.out.println(Arrays.deepToString(getIntArr(new String[]{"01101","11010","01110","11110","11111","00000"})));
        System.out.println(getTarget(getIntArr(new String[]{"01101","11010","01110","11110","11111","00000"})));
    }

    public static int[][] getIntArr(String[] arr) {
        if (arr.length == 0) return null;
        final int N = arr.length;
        final int M = arr[0].length();
        int[][] res = new int[N][M];
        for (int index = 0; index < N; index++) {
            char[] chars = arr[index].toCharArray();
            for (int col = 0; col < M; col++) {
                res[index][col] = chars[col] - '0';
            }
        }
        return res;
    }

    public static int getTarget(int[][] arr) {
        if (arr == null) return 0;
        final int N = arr.length;
        final int M = arr[0].length;
        int index = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] rowArr = new int[M];
        for (int row = 0; row < N; row++) {

            stack.push(index++);
            for (int col = 0; col < M; col++) {
                rowArr[col] = arr[row][col] + (row > 0 && arr[row][col] != 0 ? rowArr[col] : 0);
            }
            int k = 0;
            while (index < M) {
                int cur = stack.peek();
                while (cur != -1 && rowArr[cur] >= rowArr[index]) {
                    stack.pop();
                    int num = index;
                    if (!stack.isEmpty()) {
                        num = num - (stack.peek() + 1);
                    }
                    max = Math.max(max, rowArr[cur] * num);
                    cur = stack.isEmpty() ? -1 : stack.peek();
                }

                while (index < M && (cur == -1 || rowArr[cur] < rowArr[index])) {
                    stack.push(index++);
                    cur = stack.peek();
                }
            }

            while (!stack.isEmpty()) {
                int cur = stack.pop();
                max = Math.max(max, rowArr[cur] * (M - (stack.isEmpty() ? 0 : stack.peek() + 1)));
            }

            index = 0;
        }

        return max;
    }
}
