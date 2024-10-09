package com.yang.dachang.timet24t10.time04;

import java.util.Stack;

/**
 * 单调栈：求数组中所有子数组的最小值的和
 */
public class Code01 {

    public static void main(String[] args) {
        int[] ints = {3, 1, 2, 4};
        System.out.println(getTarget(ints));
        System.out.println(getTarget3(ints));
    }

    public static class LeftAndRightLess {
        public int[] left;
        public int[] right;
    }

    public static int getTarget3(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        final int N = arr.length;
        long res = 0;
        LeftAndRightLess leftAndRightLessArr = getLeftAndRightLessArr2(arr);
        int[] left = leftAndRightLessArr.left;
        int[] right = leftAndRightLessArr.right;
        for (int index = 0; index < N; index++) {
            res += (index - left[index]) * (right[index] - index) * (long) arr[index];
            res %= (1000000000 + 7);
        }
        return (int) res;
    }

    public static LeftAndRightLess getLeftAndRightLessArr2(int[] arr) {
        LeftAndRightLess leftAndRightLess = new LeftAndRightLess();
        final int N = arr.length;
        int point = -1;
        int[] stack = new int[N];
        int index = 0;
        stack[++point] = index++;
        int[] left = new int[N];
        int[] right = new int[N];
        while (index < N) {
            int cur = stack[point];
            while (cur != -1 && arr[index] < arr[cur]) {
                point--;
                left[cur] = point == -1 ? -1 : stack[point];
                right[cur] = index;
                cur = point == -1 ? -1 : stack[point];
            }

            while (index < N && (cur == -1 || arr[index] >= arr[cur])) {
                cur = index;
                stack[++point] = index++;
            }
        }

        while (point != -1) {
            int cur = stack[point--];
            left[cur] = point == -1 ? -1 : stack[point];
            right[cur] = N;
        }

        leftAndRightLess.left = left;
        leftAndRightLess.right = right;

        return leftAndRightLess;
    }

    public static int getTarget2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        final int N = arr.length;
        long res = 0;
        LeftAndRightLess leftAndRightLessArr = getLeftAndRightLessArr(arr);
        int[] left = leftAndRightLessArr.left;
        int[] right = leftAndRightLessArr.right;
        for (int index = 0; index < N; index++) {
            res += (index - left[index]) * (right[index] - index) * (long) arr[index];
            res %= (1000000000 + 7);
        }
        return (int) res;
    }

    public static LeftAndRightLess getLeftAndRightLessArr(int[] arr) {
        LeftAndRightLess leftAndRightLess = new LeftAndRightLess();
        final int N = arr.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(index++);
        int[] left = new int[N];
        int[] right = new int[N];
        while (index < N) {
            int cur = stack.peek();
            while (cur != -1 && arr[index] < arr[cur]) {
                stack.pop();
                left[cur] = stack.isEmpty() ? -1 : stack.peek();
                right[cur] = index;
                cur = stack.isEmpty() ? -1 : stack.peek();
            }

            while (index < N && (cur == -1 || arr[index] >= arr[cur])) {
                cur = index;
                stack.push(index++);
            }
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            left[cur] = stack.isEmpty() ? -1 : stack.peek();
            right[cur] = N;
        }

        leftAndRightLess.left = left;
        leftAndRightLess.right = right;

        return leftAndRightLess;
    }

    public static int getTarget(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        final int N = arr.length;
        long res = 0;
        int[] left = leftLessNessArr(arr);
        int[] right = rightLessNessArr(arr);
        for (int index = 0; index < N; index++) {
            res += (index - left[index]) * (right[index] - index) * (long) arr[index];
            res %= (1000000000 + 7);
        }
        return (int) res;
    }
    
    // left[i] -> arr[i]中左边距离i位置小于等于的位置x
    // 时间复杂度: O（N2）
    public static int[] leftLessNessArr(int[] arr) {
        final int N = arr.length;
        int[] left = new int[N];
        for (int index = 0; index < N; index++) {
            int minIndex = -1;
            for (int idx = index - 1; idx >= 0; idx--) {
                if (arr[index] >= arr[idx]) {
                    minIndex = idx;
                    break;
                }
            }
            left[index] = minIndex;
        }
        return left;
    }

    public static int[] rightLessNessArr(int[] arr) {
        final int N = arr.length;
        int[] right = new int[N];
        for (int index = 0; index < N; index++) {
            int minIndex = N;
            for (int idx = index; idx < N; idx++) {
                if (arr[index] > arr[idx]) {
                    minIndex = idx;
                    break;
                }
            }
            right[index] = minIndex;
        }
        return right;
    }

}
