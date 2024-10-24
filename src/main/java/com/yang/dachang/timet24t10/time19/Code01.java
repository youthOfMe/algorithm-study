package com.yang.dachang.timet24t10.time19;

// 测试蓄水池算法的概率
public class Code01 {

    public static int random(int num) {
        return  (int) (Math.random() * num) + 1;
    }

    public static void main(String[] args) {
        System.out.println("准备进行测试");
        int test = 100000;
        int[] count = new int[18];
        for (int times = 0; times < test; times++) {
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
            for (int num : bags) {
                count[num]++;
            }
        }

        for (int i : count) {
            System.out.println(i);
        }
    }

}
