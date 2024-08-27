package com.yang.dachang.timet24t08t26;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的所有子序列
 */
public class Code05 {

    public static void main(String[] args) {
        List<String> target = getTarget(new char[]{'a', 'b', 'c', 'a', 'b', 'c'});
        for (String s : target) {
            System.out.println(s);
        }
    }

    public static List<String> getTarget(char[] datas) {
        ArrayList<String> res = new ArrayList<>();
        process(datas, 0, res, "");
        return res;
    }

    public static void process(char[] string, int index, List<String> ans, String path) {
        if (index == string.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process(string, index + 1, ans, no);
        String yes = path + string[index];
        process(string, index + 1, ans, yes);
    }
}
