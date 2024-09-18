package com.yang.dachang.timet24t09.time17;

/**
 * 二位表如果走最省路程问题 -> 暴力递归
 */
public class Code02 {

    public static void main(String[] args) {
        int[][] dp = {
                {3, 7, 8, 8},
                {1, 2, 6, 4},
                {10, 3, 8, 9},
                {8, 1, 2, 0}
        };
        int target = getTarget(dp);
        System.out.println(target);
    }

    public static int getTarget(int[][] arr) {
        return process(arr, 0, 0);
    }

    public static int process(int[][] arr, int col, int row)  {
        if (col == arr[0].length - 1 && row == arr[0].length - 1) return arr[col][row];
        if (col == arr[0].length - 1) {
            return arr[col][row] + process(arr, col, row + 1);
        }
        if (row == arr.length - 1) {
            return arr[col][row] + process(arr, col + 1, row);
        }

        return Math.min(arr[col][row] + process(arr, col + 1, row), arr[col][row] + process(arr, col, row + 1));
    }

}
