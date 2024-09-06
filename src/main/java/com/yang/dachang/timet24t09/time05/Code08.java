package com.yang.dachang.timet24t09.time05;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列（优化版）
 */
public class Code08 {

    public static void main(String[] args) {
        for (String abc : getTarget(new char[]{'a', 'b', 'c'})) {
            System.out.println(abc);
        }
    }

    public static List<String> getTarget(char[] data) {
        List<String> res = new ArrayList<>();
        process(res, 0, "", data);
        return res;
    }

    public static void process(List<String> res, int index, String path, char[] data) {
        if (index == data.length) {
            res.add(path);
            return;
        }
        String no = path + data[index];
        process(res, index + 1, no, data);
        swap(data, index, index + 1);
        String yes = path + data[index];
        process(res, index + 1, yes, data);
        swap(data, index, index + 1);
    }

    public static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
