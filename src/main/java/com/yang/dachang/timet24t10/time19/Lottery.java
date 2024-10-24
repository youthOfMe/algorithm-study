package com.yang.dachang.timet24t10.time19;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// 使用蓄水池算法疯转的类
public class Lottery {

    // 测试使用的用户人数
    private static final int DEFAULT_PERSON_COUNT = 1000;

    // 测试的流量
    private static final int DEFAULT_FLOW_RATE = 1000;

    // 测试的停顿时间 单位ms
    private static final int DEFAULT_STOP_TIME = 10;

    // 能够中奖的人数
    private static final int DEFAULT_LOTTERY_PERSON_COUNT = 100;

    // 随机生成姓名的工具类
    private static final Util.RandomNameUtil randomNameUtil = new Util.RandomNameUtil();

    // 系统调度线程池
    // 用于调度线程资源，接受用户请求
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10000);

    // 中将名单
    private static final HashMap<Integer, String> lotteryPerson = new HashMap<>(DEFAULT_LOTTERY_PERSON_COUNT);

    // 准备回调机制
    private static final CyclicBarrier callBackFunc = new CyclicBarrier(DEFAULT_PERSON_COUNT, () -> {
        Iterator<Map.Entry<Integer, String>> iterator = lotteryPerson.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getValue());
        }

    });

    // 抽奖人记录
    private static final AtomicInteger count = new AtomicInteger(0);

    // 获取中将概率
    private static int getProbability(int num) {
        return (int) (Math.random() * num) + 1;
    }
    
    // 用户抽奖 -> 要加锁
    private static void lottery(String name) {


        // 先绝对同步 -> 一会再修改
        synchronized (Lottery.class) {
            int num = count.incrementAndGet();
            if (num <= 100) {
                lotteryPerson.put(num, name + num);
            } else {
                if (getProbability(num) <= 100) {
                    int outPersonIndex = (int) (Math.random() * DEFAULT_LOTTERY_PERSON_COUNT);
                    lotteryPerson.remove(outPersonIndex);
                    lotteryPerson.put(outPersonIndex, name + num);
                }
            }
        }
    }

    public static void process() {
        // 1. 用户准备开始请求
        int userCounts = DEFAULT_PERSON_COUNT;
        int flowRate = DEFAULT_FLOW_RATE;
        int stopTime = DEFAULT_STOP_TIME;
        int count = 0;
        while (count < userCounts) {
            count += flowRate;
            for (int time = 0; time < flowRate; time++) {
                // 2. 提交任务进行抽奖
                threadPool.execute(() -> {
                    lottery(randomNameUtil.getInfo());
                    try {
                        callBackFunc.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            try {
                // 线程停顿一会
                Thread.sleep(stopTime);
            } catch (InterruptedException e) {
                // 草率的处理错误
                e.printStackTrace();
            }
        }

    }

}
