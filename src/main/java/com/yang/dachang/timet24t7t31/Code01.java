package com.yang.dachang.timet24t7t31;

import java.util.Arrays;

/**
 * 荷兰国旗问题初级版
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,2,3,7,0};
        getTarget(arr, 4);
        String string1 = Arrays.toString(arr);
        System.out.println(string1);
        String string = arr.toString();
        System.out.println(string);
    }

    public static void getTarget(int[] arr, int targetNum) {
        int smallPoint = -1;
        int point = 0;
        while (point <= arr.length - 1) {
           if (arr[point] > targetNum) {
               point++;
           } else if (arr[point] <= targetNum) {
               swap(arr, point++, ++smallPoint);
           }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int middle = arr[a];
        arr[a] = arr[b];
        arr[b] = middle;
    }

}
