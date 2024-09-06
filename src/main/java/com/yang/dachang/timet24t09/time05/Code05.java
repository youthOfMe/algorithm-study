package com.yang.dachang.timet24t09.time05;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全部排列(纯暴力解)
 */
public class Code05 {

    public static void main(String[] args) {
        for (String s : getTarget(new char[]{'a', 'b', 'c'})) {
            System.out.println(s);
        }
    }

    public static List<String> getTarget(char[] data) {
        List<String> res = new ArrayList<>();
        process(res, "", data);
        return res;
    }


    public static void process(List<String> res, String path, char[] data) {
        if (path.length() == data.length) {
            res.add(path);
            return;
        }
        for (char datum : data) {
            int count = 0;
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == datum) {
                    count++;
                }
            }
            if (count == 0) {
                process(res, path + datum, data);
            }
        }
    }
}
