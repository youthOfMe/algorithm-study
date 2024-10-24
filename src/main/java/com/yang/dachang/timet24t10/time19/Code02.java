package com.yang.dachang.timet24t10.time19;

// 测试蓄水池算法
public class Code02 {

    public static int random(int num) {
        return (int) (Math.random() * num) + 1;
    }

    public static void main(String[] args) {
        int test = 100000;
        int[] count = new int[18];
        for (int time = 0; time < test; time++) {
            int[] bags = new int[10];
            for (int num = 0; num <= 17; num++) {
                if (num < 10) {
                    bags[num] = num;
                } else {
                   if (random(num) <= 10) {
                       int bagi = (int) (Math.random() * 10);
                       bags[bagi] = num;
                   }
                }
            }

            for (int item : bags) {
                count[item]++;
            }
        }

        for (int item : count) {
            System.out.println(item);
        }
    }

}
