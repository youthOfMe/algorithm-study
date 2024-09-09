package com.yang.dachang.timet24t09.time08;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全排列（不可出现重复排列）
 */
public class Code03 {

    public static void main(String[] args) {
    }

    public static List<String> getTarget(char[] data) {
        List<String> res = new ArrayList<>();
        if (data == null || data.length == 0) {
            return res;
        }

        return res;
    }

    public static void process(List<String> res, char[] data, int index) {
        if (index == data.length - 1) {
            res.add(String.valueOf(data));
        } else {
            for (int i = index; i < data.length; i++) {
                if (data[index] != data[i] || index == i) {
                    swap(data, i, index);
                    process(res, data, index + 1);
                    swap(data, i, index);
                }
            }
        }
    }

    public static void swap(char[] data, int a, int b) {
        char temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
