package com.yang.dachang.timet24t09.time05;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全部子序列
 */
public class Code02 {

    public static void main(String[] args) {
        List<String> target = getTarget(new char[]{'a', 'b', 'c'});
        for (String s : target) {
            System.out.println(s);
        }
    }

    public static List<String> getTarget(char[] data) {
        List<String> res = new ArrayList<>();
        if (data == null || data.length == 0) {
            return res;
        }
        process(res, 0, "", data);
        return res;
    }

    public static void process(List<String> res, int index, String path, char[] data) {
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
