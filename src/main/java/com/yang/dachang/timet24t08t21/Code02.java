package com.yang.dachang.timet24t08t21;

/**
 * 数组实现并查集完成岛问题
 */
public class Code02 {
    public static void main(String[] args) {

    }

    public static int getTarget(char[][] datas) {
        UNION union = new UNION(datas);

        for (int i = 1; i < datas[0].length; i++) {
            if (datas[0][i - 1] == '1' && datas[0][i] == '1') {
                union.union(0, i - 1, 0, i);
            }
        }

        for (int i = 1; i < datas.length; i++) {
            if (datas[i - 1][0] == '1' && datas[i][0] == '1') {
                union.union(i - 1, 0, i, 0);
            }
        }

        for (int i = 1; i < datas.length; i++) {
            for (int j = 1; j < datas[0].length; j++) {
                if (datas[i - 1][j] == '1' && datas[i][j] == '1') {
                    union.union(i - 1, j, i, j);
                }

                if (datas[i][j - 1] == '1' && datas[i][j] == '1') {
                    union.union(i, j - 1, i, j);
                }
            }
        }

        return union.sets;
    }

    public static class UNION {
        private int[] parents;
        private int[] sizes;
        private int[] help;
        private int col;
        private int sets;

        public UNION(char[][] datas) {
            col = datas[0].length;
            int row = datas.length;
            int N = col * row;
            help = new int[N];
            parents = new int[N];
            sizes = new int[N];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (datas[i][j] == '1') {
                        int index = getIndex(i, j);
                        parents[index] = index;
                        sizes[index] = 1;
                        sets++;
                    }
                }
            }
        }

        private int getIndex(int i, int j) {
            return i * col + j;
        }

        private int findHead(int data) {
            int index = 0;
            while (parents[data] != data) {
                help[index++] = data;
                data = parents[data];
            }
            for (index--; index >= 0; index--) {
                parents[help[index]] = data;
            }
            return data;
        }

        private void union(int a1, int a2, int b1, int b2) {
            int index1 = getIndex(a1, a2);
            int index2 = getIndex(b1, b2);
            int f1 = findHead(index1);
            int f2 = findHead(index2);
            if (f1 != f2) {
                int bigHead = sizes[f1] >= sizes[f2] ? f1 : f2;
                int smallHead = f1 == bigHead ? f2 : f1;
                parents[smallHead] = bigHead;
                sizes[bigHead] += smallHead;
                sets--;
            }
        }
    }
}
