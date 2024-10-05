package com.yang.dachang.timet24t10.time01;

import java.util.Stack;

/**
 * 单调栈第二题
 * 自己作为sub中最小值，sub的条件是自己是最小值
 * 求sub中有多少个元素，并求出元素*自己得到的结果
 */
public class Code05 {

    public static void main(String[] args) {
        int[] ints = {1, 5, 6, 2, 3, 7};
        System.out.println(getTarget(ints));
    }

    public static int getTarget(int[] arr) {
        final int N = arr.length;
        int max = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(index++);
        while (index < N) {
            int cur = stack.peek();
            while (cur != -1 && arr[cur] >= arr[index]) {
                stack.pop();
                max = Math.max(max, (index - cur) * arr[cur]);
                cur = stack.isEmpty() ? -1 : stack.peek();
            }
            while (index < N && arr[cur] < arr[index]) {
                cur = index;
                stack.push(index++);
            }
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            max = Math.max(arr[cur] * (N - cur), max);
        }
        return max;
    }

}
