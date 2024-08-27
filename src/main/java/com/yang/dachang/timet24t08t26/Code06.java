package com.yang.dachang.timet24t08t26;

import java.util.HashSet;

/**
 * 打印字符串的所有子序列, 去除所有相同的字面量
 */
public class Code06 {

    public static void main(String[] args) {
        HashSet<String> res = getTarget(new char[]{'a', 'b', 'c', 'a', 'b', 'c'});
        res.forEach(System.out::println);
    }

    public static HashSet<String> getTarget(char[] datas) {
        HashSet<String> res = new HashSet<>();
        process(datas, 0, res, "");
        return res;
    }

    public static void process(char[] string, int index, HashSet<String> ans, String path) {
        if (index == string.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process(string, index + 1, ans, no);
        String yes = path + String.valueOf(string[index]);
        process(string, index + 1, ans, yes);
    }
}
