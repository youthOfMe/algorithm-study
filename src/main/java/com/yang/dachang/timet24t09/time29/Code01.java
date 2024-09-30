package com.yang.dachang.timet24t09.time29;

import java.util.Stack;

/**
 * 使用单调栈分析无重复数据的数组中的信息
 */
public class Code01 {

    public static void main(String[] args) {
        int[] dp = {1, 2, 8, 5, 1, 3};
        getTarget(dp);
    }

    public static void getTarget(int[] arr) {
        final int N = arr.length;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(index++);
        while (index < N) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[index]) {
                int cur = stack.pop();
                int leftSmall = stack.isEmpty() ? -1 : arr[stack.peek()];
                int rightSmall = arr[index];
                System.out.println("位置 = " + cur + " , 数据 = " + arr[cur] + " , 左最小 = " + leftSmall + " 右最小 = " + rightSmall);
            }
            stack.push(index);
            index++;
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int leftSmall = stack.isEmpty() ? -1 : arr[stack.peek()];
            int rightSmall = -1;
            System.out.println("位置 = " + cur + " , 数据 = " + arr[cur] + " , 左最小 = " + leftSmall + " 右最小 = " + rightSmall);
        }
    }

}
