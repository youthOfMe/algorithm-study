package com.yang.dachang.timet24t8t04;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序（非递归版）
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static class Wrap {
        public int left;
        public int right;
        public Wrap(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void getTarget(int[] arr, int left, int right) {
        if (arr == null && arr.length < 2) {
            return;
        }

        if (left >= right) {
            return;
        }

        Stack<Wrap> stack = new Stack<>();
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        Wrap wrap = new Wrap(left, right);
        stack.push(wrap);
        while (!stack.isEmpty()) {
            Wrap currentWrap = stack.pop();
            int L = currentWrap.left - 1;
            int R = currentWrap.right;
            int target = currentWrap.right;
            int index = L + 1;
            while (index < R) {
                if (arr[index] < arr[target]) {
                    swap(arr, index++, ++L);
                } else if (arr[index] == arr[target]) {
                    index++;
                } else {
                    swap(arr, index, --R);
                }
            }
            swap(arr, target, R++);

            if (L - currentWrap.left > 0 && L > currentWrap.left) {
                swap(arr, currentWrap.left + (int) (Math.random() * (L - currentWrap.left + 1)), L);
                wrap = new Wrap(currentWrap.left, L);
                stack.push(wrap);
            }

            if (currentWrap.right - R > 0 && currentWrap.right > R) {
                swap(arr, R + (int) (Math.random() * (currentWrap.right - R + 1)), currentWrap.right);
                wrap = new Wrap(R, currentWrap.right);
                stack.push(wrap);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
