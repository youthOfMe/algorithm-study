package com.yang.dachang.timet24t8t07;

import java.util.*;

/**
 * 最多重合线段数（堆实现）
 */
public class Code01 {

    public static void main(String[] args) {
        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line(1, 5));
        lineList.add(new Line(0, 2));
        lineList.add(new Line(1, 3));
        lineList.add(new Line(1, 2));
        lineList.add(new Line(2, 3));
        lineList.sort(Comparator.comparingInt(o -> o.start));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (Line line : lineList) {
            while (!heap.isEmpty() && heap.peek() <= line.start) {
                heap.poll();
            }
            heap.add(line.end);
            max = Math.max(max, heap.size());
        }

        System.out.println(max);
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
