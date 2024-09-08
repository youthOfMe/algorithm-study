package com.yang.dachang.timet24t09.time06;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串排列（暴力递归优化版）
 */
public class Code02 {

    public static void main(String[] args) {

        for (String s : getTarget(new char[]{'a', 'b', 'c'})) {
            System.out.println(s);
        }

    }

    public static List<String> getTarget(char[] data) {
        List<String> res = new ArrayList<>();
        if (data == null || data.length == 0) {
            return res;
        }

        process(data, 0, res);
        return res;
    }

    public static void process(char[] str, int index, List<String> res) {
        if (index == str.length - 1) {
            res.add(String.valueOf(str));
        } else {
            for (int i = index; i < str.length; i++) {
                swap(str, i, index);
                process(str, index + 1, res);
                swap(str, i, index);
            }
        }
    }

    public static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
