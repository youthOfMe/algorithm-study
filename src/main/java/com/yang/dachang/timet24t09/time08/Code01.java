package com.yang.dachang.timet24t09.time08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 打印字符串的全排列
 */
public class Code01 {

    public static void main(String[] args) {
        for (String s : getTarget(new Character[]{'a', 'b', 'c'})) {
            System.out.println(s);
        }
    }

    public static List<String> getTarget(Character[] data) {
        List<String> res = new ArrayList<>();
        if (data == null || data.length == 0) {
            return res;
        }

        List<Character> rest = Arrays.stream(data).collect(Collectors.toList());
        process(res, rest, "");
        return res;
    }

    public static void process(List<String> res, List<Character> rest, String path) {
        if (rest.isEmpty()) {
            res.add(path);
        } else {
            for (int i = 0; i < rest.size(); i++) {
                char cur = rest.remove(i);
                process(res, rest, path + cur);
                rest.add(i, cur);
            }
        }
    }

}
