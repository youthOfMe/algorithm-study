package com.yang.dachang.timet24t08t28;

import java.util.Arrays;

/**
 * 荷兰国旗问题初级版
 */
public class Code06 {

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,2,3,7,0};
        getTarget(arr, 4);
        String string1 = Arrays.toString(arr);
        System.out.println(string1);
    }

    public static void getTarget(int[] arr, int x) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int small = -1;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[cur] < x) {
                swap(arr, ++small, cur++);
            } else {
                cur++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
