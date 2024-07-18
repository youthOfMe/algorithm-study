package com.yang.dachang.oneday;

import java.util.HashMap;
import java.util.HashSet;

// 一种数出现k次其他数出现m次
public class Code07 {

    // 定义稳测函数
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int item : arr) {
            if (hashMap.containsKey(item)) {
                hashMap.put(item, hashMap.get(item) + 1);
            } else {
                hashMap.put(item, 1);
            }
        }

        for (Integer num : hashMap.keySet()) {
            if (hashMap.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    // 定义算法函数
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];

        for (int item : arr) {
            for (int i = 0; i <= 31; i++) {
                t[i] += (item & (1 << i)) == 0 ? 0 : 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    // 生成随机数组
    public static int[] getRandomArr(int maxKind, int range, int m, int k) {
        int onlyNum = getRandom(range);
        int[] arr = new int[k + (maxKind - 1) * m];
        int index = 0;
        for (int i = 0; i < k; i++) {
            arr[index++] = onlyNum;
        }

        maxKind = maxKind - 1;
        HashSet hashSet = new HashSet();
        hashSet.add(onlyNum);
        while (maxKind > 0) {
            maxKind = maxKind - 1;
            int mNum = 0;
            do {
                mNum = getRandom(range);
            } while (hashSet.contains(mNum));
            hashSet.add(mNum);
            for (int i = 0; i < m; i++) {
                arr[index++] = mNum;
            }
        }
        // 打乱数组
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // 生成 1 - 200的随机数
    public static int getRandom(int range) {
        return (int) (Math.random() * (range - 1)) + 1;
    }

    public static void main(String[] args) {
        // 定义最大种数
        int maxKind = 10;
        // 定义生成数的范围
        int range = 200;
        // 定义测试次数
        int times = 50;

        for (int i = 0; i < times; i++) {
            int k = (int)(Math.random() * 9) + 1;
            int m = (int)(Math.random() * 9) + 1;
            int tmp = Math.min(k, m);
            if (k > m) {
                int tmpn = k;
                k = m;
                m = tmpn;
            }
            int[] randomArr = getRandomArr(maxKind, range, m, k);
            // int[] randomArr = {1, 1, 1, 1, 6, 6, 6, 8, 8, 8, 8, 88, 88, 88, 88, 66, 66, 66, 66};
            int test = test(randomArr, k, m);
            int ans = onlyKTimes(randomArr, k, m);
            // int test = test(randomArr, 3, 4);
            // int ans = onlyKTimes(randomArr, 3, 4);
            if (test != ans) {
                System.out.println("出错" + i + ", ans=" + ans + ", test=" + test);
            }
        }
    }
}
