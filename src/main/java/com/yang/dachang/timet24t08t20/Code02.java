package com.yang.dachang.timet24t08t20;

/**
 * 非并查集完成岛屿数量问题
 */
public class Code02 {

    public static void main(String[] args) {

    }

    public static void getTarget(char[][] initData){
        int isLands = 0;
        for (int i = 0; i < initData.length; i++) {
            for (int j = 0; j < initData[0].length; j++) {
                if (initData[i][j] == '1') {
                    isLands++;
                }
            }
        }
    }

    public static void process(char[][] initData, int i, int j) {
        if (i < 0 || i == initData.length || j < 0 || j == initData[0].length || initData[i][j] != '1') {
            return;
        }
        initData[i][j] = 0;
        process(initData, i - 1, j);
        process(initData, i, j - 1);
        process(initData, i, j + 1);
        process(initData, i + 1, j);
    }
}
