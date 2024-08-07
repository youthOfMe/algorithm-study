package com.yang.dachang.timet24t8t06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * K线段问题
 */
public class Code03 {

    public static void main(String[] args) {

        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line(1, 5));
        lineList.add(new Line(0, 2));
        lineList.add(new Line(1, 3));
        lineList.add(new Line(1, 2));
        lineList.add(new Line(2, 3));
        HashMap<Double, Integer> hashMap = new HashMap<>();
        int min = 0;
        int max = 5;
        for (int i = min; i < max; i++) {
            hashMap.put(i + 0.5, 0);
        }
        for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
            double key = entry.getKey();
            for (int i = 0; i < lineList.size(); i++) {
                if(lineList.get(i).start < key && lineList.get(i).end > key) {
                    hashMap.put(key, entry.getValue() + 1);
                }
            }
        }
        int result = 0;
        for (Integer value : hashMap.values()) {
            if (value > result) {
                result = value;
            }
        }
        System.out.println(result);
    }

    public static class Line {
        public int start;
        public int end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
