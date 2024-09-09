package com.yang.dachang.timet24t09.time08;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列（特别优化版）
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

        process(res, data, 0);
        return res;
    }

    public static void process(List<String> res, char[] data, int index) {
        if (index == data.length - 1) {
            res.add(String.valueOf(data));
        } else {
            for (int i = index; i < data.length; i++) {
                swap(data, i, index);
                process(res, data, index + 1);
                swap(data, i, index);
            }
        }
    }

    public static void swap(char[] data, int a, int b) {
        char temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
