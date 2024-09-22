package com.yang.dachang.timet24t09.time21;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 咖啡问题 - 第一问 - 小根堆解决
 */
public class Code03 {

    public static class Machine {
        public int timePoint;
        public int workTime;

        public Machine(int timePoint, int workTime) {
            this.timePoint = timePoint;
            this.workTime = workTime;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {
        @Override
        public int compare(Machine machine1, Machine machine2) {
            return (machine1.timePoint + machine2.workTime) - (machine2.timePoint + machine2.workTime);
        }
    }

    // 咖啡机 n个人 挥发时间 洗咖啡的时间
    public static int[] getDrinks(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine machine = heap.poll();
            machine.timePoint = machine.timePoint + machine.workTime;
            heap.add(machine);
            drinks[i] = machine.timePoint;
        }
        return drinks;
    }

}
