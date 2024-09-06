package com.yang.dachang.timet24t09.time05;

import java.util.HashSet;
import java.util.Set;

/**
 * 打印字符串的所有子序列（不可有重复）
 */
public class Code04 {

    public static void main(String[] args) {
        Set<String> target = getTarget(new char[]{'a', 'b', 'c', 'a'});
        for (String s : target) {
            System.out.println(s);
        }
    }

    public static Set<String> getTarget(char[] data) {
        Set<String> res = new HashSet<>();
        if (data == null || data.length == 0) {
            return res;
        }
        process(res, 0, "", data);
        return res;
    }

    public static void process(Set<String> res, int index, String path, char[] data) {
        // baseCase
        if (index == data.length) {
            res.add(path);
            return;
        }
        String no = path;
        process(res, index + 1, no, data);
        String yes = path + data[index];
        process(res, index + 1, yes, data);
    }

}
