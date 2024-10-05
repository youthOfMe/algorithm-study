package com.yang.dachang.timet24t10.time01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 实现可重复数单调栈打印数组中的左右最邻近比自己小的数
 */
public class Code03 {

    public static void main(String[] args) {
        int[] ints = {1, 5, 6, 5, 7, 1, 3, 2, 3, 7};
        System.out.println(Arrays.deepToString(getRes(ints)));
    }

    public static int[][] getRes(int[] arr) {
        final int N = arr.length;
        int[][] res = new int[N][2];
        int index = 0;
        Stack<List<Integer>> stack = new Stack<>();
        LinkedList<Integer> one = new LinkedList<>();
        one.push(index++);
        stack.push(one);
        while (index < N) {
            List<Integer> cur = stack.peek();
            while (cur != null && arr[cur.get(0)] > arr[index]) {
                stack.pop();
                for (int idx : cur) {
                    res[idx][0] = stack.isEmpty() ? -1 : stack.peek().get(0);
                    res[idx][1] = index;
                }
                cur = stack.isEmpty() ? null : stack.peek();
            }

            while (index < N && cur != null && arr[cur.get(0)] == arr[index]) {
                cur.add(index++);
            }

            while (index < N && (cur == null || arr[cur.get(0)] < arr[index])) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(index++);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> cur = stack.pop();
            for (int idx : cur) {
                res[idx][0] = stack.isEmpty() ? -1 : stack.peek().get(0);
                res[idx][1] = -1;
            }
        }

        return res;
    }

}
