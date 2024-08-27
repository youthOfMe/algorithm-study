package com.yang.dachang.timet24t08t27;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列（牛逼版）
 */
public class Code02 {

    public static void main(String[] args) {
        for (String abc : getTarget("abc")) {
            System.out.println(abc);
        }

    }

    public static List<String> getTarget(String string) {
        ArrayList<String> res = new ArrayList<>();
        if (string == null || string.isEmpty()) {
            res.add("");
            return res;
        }
        f(string.toCharArray(), 0, res);
        return res;
    }

    public static void f(char[] string, int index, List<String> res) {
        if (index == string.length) {
            res.add(String.valueOf(string));
        } else {
            for (int i = index; i < string.length; i++) {
                swap(index, i, string);
                f(string, index + 1,  res);
                swap(index, i, string);
            }
        }
    }

    public static void swap(int a, int b, char[] data) {
        char temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
