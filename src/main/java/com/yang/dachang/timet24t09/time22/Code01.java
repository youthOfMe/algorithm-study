package com.yang.dachang.timet24t09.time22;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 咖啡问题 - 第一问求出最优排序下，drinks数组 - 小根堆解决
 */
public class Code01 {

    public static class Machine {
        public int endTimePoint;
        public int waitTimePoint;

        public Machine(int endTimePoint, int waitTimePoint) {
            this.endTimePoint = endTimePoint;
            this.waitTimePoint = waitTimePoint;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {

        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.endTimePoint + o2.waitTimePoint) - (o2.endTimePoint + o2.waitTimePoint);
        }
    }

    public static int[] getDrinks(int[] machines, int n, int a, int b) {
        PriorityQueue<Machine> queue = new PriorityQueue<>();
        for (int machine : machines) {
            queue.add(new Machine(0, machine));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine machine = queue.poll();
            machine.endTimePoint = machine.endTimePoint + machine.waitTimePoint;
            drinks[i] = machine.endTimePoint;
            queue.add(machine);
        }
        return drinks;
    }

}
