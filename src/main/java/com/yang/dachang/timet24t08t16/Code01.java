package com.yang.dachang.timet24t08t16;

import java.util.*;

/**
 * 贪心算法1
 */
public class Code01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("l");
        list.add("b");
        list.add("c");
        String target = getTarget(list);
        System.out.println(target);
        System.out.println(getTargetByGood(list));
    }

    // 暴力方法
    public static String getTarget(List<String> strList) {
        TreeSet<String> ans = process(strList.toArray(new String[strList.size()]));
        return ans.size() == 0 ? "" : ans.first();
    }

    public static TreeSet<String> process(String[] stringList) {
        TreeSet<String> treeSet = new TreeSet<>();
        if (stringList.length == 0) {
            treeSet.add("");
            return treeSet;
        }
        for (int i = 0; i < stringList.length; i++) {
            String first = stringList[i];
            String[] nexts = removeIndexString(stringList, i);
            TreeSet<String> next = process(nexts);
            for (String cur : next) {
                treeSet.add(first + cur);
            }
        }
        return treeSet;
    }

    public static String[] removeIndexString(String[] str, int i) {
        int N = str.length;
        String[] res = new String[N - 1];
        int index = 0;
        for (int j = 0; j < N; j++) {
            if (j != i) {
                res[index++] = str[j];
            }
        }
        return res;
    }

    // 贪心算法实现
    public static class CompareStr implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String getTargetByGood(List<String> list) {
        String[] strings = list.toArray(new String[list.size()]);
        Arrays.sort(strings, new CompareStr());
        String ans = "";
        for (String string : strings) {
            ans += string;
        }
        return ans;
    }
}
