package com.yang.dachang.timet24t09.time05;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印1个字符串的全部子序列
 */
public class Code01 {

    public static void main(String[] args) {
        List<String> target = getTarget(new char[]{'a', 'b', 'c'});
        for (String s : target) {
            System.out.println(s);
        }
    }

    public static List<String> getTarget(char[] data) {
        List<String> res = new ArrayList<>();
        getAllChildStr(res, "", 0, data);
        return res;
    }

    public static void getAllChildStr(List<String> res, String path, int index, char[] data) {
        if (index == data.length) {
            res.add(path);
            return;
        }
        String no = path;
        getAllChildStr(res, no, index + 1, data);
        String yes = path + data[index];
        getAllChildStr(res, yes, index + 1, data);
    }

}
