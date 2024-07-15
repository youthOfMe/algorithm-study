package com.yang.dachang.oneday;

// 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这个数？
public class Code03 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3, 3, 55, 55, 69, 69, 88, 88, 88, 88, 9465};

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        System.out.println(result);
    }
}
