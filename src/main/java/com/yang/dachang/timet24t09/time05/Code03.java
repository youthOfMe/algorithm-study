package com.yang.dachang.timet24t09.time05;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全部子序列
 */
public class Code03 {

    public static void main(String[] args) {
        for (String s : getTarget("abc")) {
            System.out.println(s);
        }

    }

    public static List<String> getTarget(String data) {
        List<String> res = new ArrayList<>();
        if (data == null || data.isEmpty()) {
            return res;
        }
        process(res, 0, "", data);
        return res;
    }

    public static void process(List<String> res, int index, String path, String data) {
        if (index == data.length()) {
            res.add(path);
            return;
        }
        String no = path;
        process(res, index + 1, no, data);
        String yes = path + data.charAt(index);
        process(res, index + 1, yes, data);
    }

}
