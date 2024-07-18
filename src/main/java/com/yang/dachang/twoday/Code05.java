package com.yang.dachang.twoday;


public class Code05 {

    public static int getTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 98, 588, 598, 5555, 45645, 898989};
        System.out.println(getTarget(arr, 45645));
    }
}
