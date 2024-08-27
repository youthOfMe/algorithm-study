package com.yang.dachang.timet24t08t27;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全排列（垃圾版）
 */
public class Code01 {

    public static void main(String[] args) {
        List<String> target = getTarget(new char[]{'a', 'b', 'c'});
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
        ArrayList<Character> rest = new ArrayList<>();
        for (char cha : string) {
            rest.add(cha);
        }
        f(rest, "", res);
        return res;
    }

    public static List<String> getTarget(String string) {
        ArrayList<String> res = new ArrayList<>();
        if (string == null || string.isEmpty()) {
            res.add("");
            return res;
        }
        ArrayList<Character> rest = new ArrayList<>();
        for (char cha : string.toCharArray()) {
            rest.add(cha);
        }
        f(rest, "", res);
        return res;
    }

    public static void f(List<Character> rest, String path, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(path);
            return;
        } else {
            for (int i = 0; i < rest.size(); i++) {
                Character removeChar = rest.remove(i);
                f(rest, path + removeChar, ans);
                rest.add(i, removeChar);
            }
        }
    }
}
