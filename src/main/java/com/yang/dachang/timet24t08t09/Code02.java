package com.yang.dachang.timet24t08t09;

import java.util.Arrays;

/**
 * 计数排序
 */
public class Code02 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 6, 5, 8, 2, 0, 0, 3, 25, 62, 2, 5, 5};
        // int[] arr = {3, 1, 0, 4, 3, 1};
        getTarget(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 计数排序 将公司中的人按年纪排序 0 - 200
    public static void getTarget(int[] arr) {
        int[] help = new int[201];

        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] != 0) {
                arr[j++] = i;
                if (help[i]-- != 0) {
                    i--;
                }
            }
        }
    }
}
