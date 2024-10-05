package com.yang.dachang.timet24t10.time01;

import java.util.Stack;

/**
 * 实现不重复数单调栈打印数组中的左右最邻近比自己小的数
 */
public class Code01 {

    public static void main(String[] args) {
        int[] ints = {1, 5, 6, 2, 3, 7};
        printArr(ints);
    }

    public static void printArr(int[] arr) {
        final int N = arr.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(index++);
        while (index < N) {
            int top = stack.peek();

            while (top != -1 && arr[index] < arr[top]) {
                stack.pop();
                int leftSmall = -1;
                if (!stack.isEmpty()) {
                    leftSmall = arr[stack.peek()];
                }
                System.out.println("位置: " + top + " , 数据: " + arr[top] + " , 左边比自己小的最近数: " + leftSmall + " , 右边比自己小的最近数: " + arr[index] + " 。");
                top = stack.isEmpty() ? -1 : stack.peek();
            }

            while (index < N && arr[index] > arr[top]) {
                stack.push(index++);
                top = stack.peek();
            }
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int leftSmall = -1;
            if (!stack.isEmpty()) {
                leftSmall = arr[stack.peek()];
            }
            System.out.println("位置: " + cur + " , 数据: " + arr[cur] + " , 左边比自己小的最近数: " + leftSmall + " , 右边比自己小的最近数:  -1。");
        }
    }

}
