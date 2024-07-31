package com.yang.dachang.timet24t7t31;

import java.util.Arrays;

/**
 * 荷兰国旗问题（高级版）
 */
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,2,3,7,0};
        getTarget(arr, 4);
        String string1 = Arrays.toString(arr);
        System.out.println(string1);
    }

    public static void getTarget(int[] arr, int targetNum) {
        int smallPoint = -1;
        int bigPoint = arr.length;
        int point = 0;
        while (point <= bigPoint) {
            if (arr[point] > targetNum) {
                swap(arr, --bigPoint, point++);
            } else if (arr[point] < targetNum) {
                swap(arr, ++smallPoint, point++);
            } else {
                point++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int middle = arr[a];
        arr[a] = arr[b];
        arr[b] = middle;
    }
}
