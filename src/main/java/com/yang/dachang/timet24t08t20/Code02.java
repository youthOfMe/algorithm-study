package com.yang.dachang.timet24t08t20;

/**
 * 非并查集完成岛屿数量问题
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static int getTarget(int[][] initData){
        int res = 0;
        for (int i = 0; i < initData.length; i++) {
            for (int j = 0; j < initData[0].length; j++) {
                if (initData[i][j] == 1) {
                   res = Math.max(res, process(initData, i, j, 1));
                }
            }
        }
        return res;
    }

    public static int process(int[][] initData, int i, int j, int isArea) {
        if (i < 0 || i == initData.length || j < 0 || j == initData[0].length || initData[i][j] != 1) {
            return 0;
        }
        initData[i][j] = 0;
        isArea += process(initData, i - 1, j, 1);
        isArea += process(initData, i, j - 1, 1);
        isArea += process(initData, i, j + 1, 1);
        isArea += process(initData, i + 1, j, 1);
        return isArea;
    }
}
