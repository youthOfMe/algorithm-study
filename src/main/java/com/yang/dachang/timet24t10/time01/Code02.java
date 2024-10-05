package com.yang.dachang.timet24t10.time01;

import java.util.Arrays;
import java.util.Stack;

/**
 * 实现不重复数单调栈打印数组中的左右最邻近比自己小的数
 */
public class Code02 {

    public static void main(String[] args) {
        int[] ints = {1, 5, 6, 2, 3, 7};
        System.out.println(Arrays.deepToString(getRes(ints)));
    }

    public static int[][] getRes(int[] arr) {
        final int N = arr.length;
        int[][] res = new int[N][2];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(index++);
        while (index < N) {
            int top = stack.peek();
            while (top != -1 && arr[top] > arr[index]) {
                stack.pop();
                res[top][0] = stack.isEmpty() ? -1 : stack.peek();
                res[top][1] = index;
                top = res[top][0];
            }

            while (index < N && arr[top] < arr[index]) {
                top = index;
                stack.push(index++);
            }
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            res[cur][0] = stack.isEmpty() ? -1 : stack.peek();
            res[cur][1] = -1;
        }

        return res;
    }

}
