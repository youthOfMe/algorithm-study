package com.yang.dachang.timet24t09.time22;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 咖啡问题 - 第二问: 求出被子干净后的最早时间（暴力递归）
 */
public class Code02 {

    public static class Machine {
        public int endTimePoint;
        public int waitTimePoint;

        public Machine(int endTimePoint, int waitTimePoint) {
            this.endTimePoint = endTimePoint;
            this.waitTimePoint = waitTimePoint;
        }
    }

    public static class MachineComparator implements Comparator<Code01.Machine> {

        @Override
        public int compare(Code01.Machine o1, Code01.Machine o2) {
            return (o1.endTimePoint + o2.waitTimePoint) - (o2.endTimePoint + o2.waitTimePoint);
        }
    }

    public static int[] getDrinks(int[] machines, int n, int a, int b) {
        PriorityQueue<Code01.Machine> queue = new PriorityQueue<>();
        for (int machine : machines) {
            queue.add(new Code01.Machine(0, machine));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Code01.Machine machine = queue.poll();
            machine.endTimePoint = machine.endTimePoint + machine.waitTimePoint;
            drinks[i] = machine.endTimePoint;
            queue.add(machine);
        }
        return drinks;
    }

    public static int getTarget(int[] drinks, int n, int wash, int air) {
        return process(drinks, n, wash, air, 0, 0);
    }

    public static int process(int[] drinks, int n, int wash, int air, int index, int free) {
        if (index == drinks.length) return 0;

        int selfWashTime = Math.max(drinks[index], free) + wash;
        int otherWashTime = process(drinks, n, wash, air, index + 1, free + selfWashTime);
        int p1 = Math.max(selfWashTime, otherWashTime);

        int selfAirTime = drinks[index] + air;
        int otherAirTime = process(drinks, n, wash, air, index + 1, free);
        int p2 = Math.max(selfAirTime, otherAirTime);

        return Math.min(p1, p2);
    }

}
