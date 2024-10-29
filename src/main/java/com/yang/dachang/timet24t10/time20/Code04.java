package com.yang.dachang.timet24t10.time20;

/**
 * N皇后问题
 */
public class Code04 {

    public static void main(String[] args) {
        System.out.println(getTarget(4));
    }

    public static int getTarget(int n) {
        if (n < 1) return -1;
        // 定义record的下标对应放在了第几行, 里面的数据对应放在了第几列
        int[] record = new int[n];
        return process(0, n, record);
    }

    /**
     * 流程函数
     *
     * @param index 处理到哪个皇后了
     * @param n 一共处理多少个皇后
     * @param record 记录值 -> 前面的皇后都放在什么位置了
     * @return
     */
    public static int process(int index, int n, int[] record) {
        // 能走到最后就OK
        if (index == n) return 1;
        // 定义结果数据
        int res = 0;
        // 所有的皇后每个位置都要尝试一下
        for (int col = 0; col < n; col++) {
            if (isValid(col, index, record)) {
                record[index] = col;
                res += process(index + 1, n, record);
            }
        }
        return res;
    }

    /**
     * 校验是否可行的函数
     *
     * @param col 当前皇后放在第几行
     * @param index 当前是第几个皇后
     * @param record 记录数组
     * @return
     */
    public static boolean isValid(int col, int index, int[] record) {
        for (int pre = 0; pre < index; pre++) {
            // 如果在同列/同斜线上，就意味着冲突了，这个位置不可行
            if (col == record[pre] || Math.abs(index - pre) == Math.abs(col - record[pre])) {
                return false;
            }
        }
        return true;
    }

}
