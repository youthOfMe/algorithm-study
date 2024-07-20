package com.yang.dachang.timet24t7t16;

public class Code06 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 6, 6, 6, 8, 8, 8, 8, 88, 88, 88, 88, 66, 66, 66, 66};

        getTarget(arr, 3, 4);
    }

    public static void getTarget(int[] arr, int k, int m) {
        // 初始化答案
        int ans = 0;

        // 定义一个固定数组
        int[] timesArr = new int[32];

        // 循环判断存储1的次数
        for (int item : arr) {
            for (int i = 31; i >= 0; i--) {
                timesArr[i] += ((1 << i) & item) == 0 ? 0 : 1;
            }
        }

        for (int i = 0; i < timesArr.length; i++) {
            if (timesArr[i] % m != 0) {
                ans |= (1 << i);
            }
        }

        System.out.println(ans);
    }
}
