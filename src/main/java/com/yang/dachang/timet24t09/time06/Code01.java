package com.yang.dachang.timet24t09.time06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 打印字符串排列（真纯暴力解）
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

        List<Character> rest = new ArrayList<>(data.length);
        Collections.addAll(rest, data);
        process(rest, res, "");

        return res;
    }

    public static void process(List<Character> rest, List<String> ans, String path) {
        if (rest.isEmpty()) {
            ans.add(path);
        } else {
            for (int i = 0; i < rest.size(); i++) {
                Character cur = rest.remove(i);
                process(rest, ans, path + cur);
                rest.add(i, cur);
            }
        }
    }

}
