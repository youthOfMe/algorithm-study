package com.yang.dachang.timet24t09.time22;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 咖啡问题 - 第二问: 求出被子干净后的最早时间（动态规划）
 */
public class Code03 {

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
        PriorityQueue<Machine> queue = new PriorityQueue<>(new MachineComparator());
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

    public static int getTarget(int[] drinks, int n, int wash, int air) {
        return process(drinks, n, wash, air);
    }

    public static int process(int[] drinks, int n, int wash, int air) {
        int len = drinks.length;
        int maxFree = 0;
        for (int drink : drinks) {
            maxFree = Math.max(maxFree, drink) + wash;
        }
        int[][] dp = new int[len + 1][maxFree + 1];
        for (int index = len - 1; index >= 0; index++) {
            for (int free = 0; free <= maxFree; free++) {
                if (free + wash > maxFree) continue;
                int selfWashTime = Math.max(drinks[index], free) + wash;
                int otherWashTime = dp[index + 1][free + wash];
                int p1 = Math.max(selfWashTime, otherWashTime);

                int selfAirTime = drinks[index] + air;
                int otherAirTime = dp[index + 1][free];
                int p2 = Math.max(selfAirTime, otherAirTime);

                dp[index][free] = Math.min(p1, p2);
            }
        }

        return dp[0][0];
    }

}
