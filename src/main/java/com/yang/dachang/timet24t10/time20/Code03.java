package com.yang.dachang.timet24t10.time20;

/**
 * N皇后问题
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public int getTarget(int n) {
        if (n < 1) return 0;
        // 使用record的角标作为行(第几个), 存储的是列(数据在第几列)
        int[] record = new int[n];
        return process(0, record, n);
    }

    public int process(int index, int[] record, int n) {
        // 假设能走到最后
        if (index == n) {
            return 1;
        }
        // 记录的结果
        int res = 0;
        // 将每一个位置都试一下
        for (int col = 0; col < n; col++) {
            // 进行校验，看看这个位置是否可行
            // index -> 第几个, record -> 记录值, col -> 放在第几列
            if (valid(index, record, col)) {
                record[index] = col;
                 res += process(index + 1, record, n);
            }
        }
        return res;
    }

    public boolean valid(int index, int[] record, int col) {
        for (int idx = 0; idx < index; idx++) {
            if (record[idx] == col || Math.abs(record[idx] - col) == Math.abs(idx - index)) {
               return false;
            }
        }
        return true;
    }

}
