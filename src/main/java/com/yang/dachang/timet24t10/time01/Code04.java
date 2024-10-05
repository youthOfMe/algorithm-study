package com.yang.dachang.timet24t10.time01;

import java.util.Stack;

/**
 * 单调栈第一题
 * 求出数组中子数组sub中sum * min最大的值
 * 使用单调栈，框出以index为min，最大范围的数组，保证sum最大，且有min
 * 使用前缀和数组保证获取sum时，O（1）
 */
public class Code04 {

    public static void main(String[] args) {
        int[] ints = {1, 5, 6, 2, 3, 7};
        System.out.println(getTarget(ints));
    }

    public static int[] getSumArr(int[] arr) {
        final int N = arr.length;
        int[] res = new int[N];
        res[0] = arr[0];
        for (int i = 1; i < N; i++) {
            res[i] = res[i - 1] + arr[i];
        }
        return res;
    }

    public static int getTarget(int[] arr) {
        final int N = arr.length;
        int[] sumArr = getSumArr(arr);
        int max = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(index++);
        while (index < N) {
            int cur = stack.peek();
            while (cur != -1 && arr[cur] >= arr[index]) {
                stack.pop();
                max = Math.max(max, (sumArr[index++] - ((cur - 1 >= 0) ? sumArr[cur - 1] : 0)) * arr[cur]);
                cur = stack.isEmpty() ? -1 : stack.peek();
            }
            while (index < N && arr[cur] < arr[index] ) {
                stack.push(index++);
            }
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            max = Math.max(max, sumArr[cur] * arr[cur]);
        }

        return max;
    }

}
