package com.yang.dachang.twoday;

public class Code04 {
    // 二分法查找数组种指定数的角标
    public static void main(String[] args) {
        int[] arr = {1, 98, 588, 598, 5555, 45645, 898989};
        System.out.println(getResult(arr, 45645));
    }

    public static int getResult(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        // 定义必须有两个数为边界值
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
