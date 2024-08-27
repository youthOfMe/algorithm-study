package com.yang.dachang.timet24t08t27;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列（去重版）
 */
public class Code03 {

    public static void main(String[] args) {
        List<String> target = getTarget(new char[]{'a', 'b', 'c', 'a'});
        for (String s : target) {
            System.out.println(s);
        }
    }

    public static List<String> getTarget(char[] string) {
        ArrayList<String> res = new ArrayList<>();
        if (string == null || string.length == 0) {
            res.add("");
            return res;
        }
        f(string, 0, res);
        return res;
    }

    public static void f(char[] string, int index, List<String> ans) {
        if (string.length == index) {
            ans.add(String.valueOf(string));
        } else {
            for (int i = index; i < string.length; i++) {
                if (string[index] != string[i] || index == i) {
                    swap(index, i, string);
                    f(string, index + 1, ans);
                    swap(index, i, string);
                }
            }
        }
    }

    public static void swap(int a, int b, char[] data) {
        char temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
