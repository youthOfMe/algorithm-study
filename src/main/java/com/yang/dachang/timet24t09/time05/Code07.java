package com.yang.dachang.timet24t09.time05;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列（动态规划）
 */
public class Code07 {

    public static void main(String[] args) {
        System.out.println(getTarget(3));
    }

    public static int getTarget(int n) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        dataMap.put(1, 1);
        dataMap.put(2, 1);
        return process(n, dataMap);
    }

    public static int process(int n, Map<Integer, Integer> dataMap) {
        if (dataMap.containsKey(n)) {
            return dataMap.get(n);
        }
        int res = process(n - 1, dataMap) + process(n - 2, dataMap);
        dataMap.put(n, res);
        return res;
    }

}
