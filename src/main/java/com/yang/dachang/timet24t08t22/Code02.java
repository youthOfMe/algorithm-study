package com.yang.dachang.timet24t08t22;

public class Code02 {

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
            for (int j = 1; j < datas[i].length; j++) {
                if (datas[i - 1][j] == '1' && datas[i][j] == '1') {
                    union.union(i - 1, j, i, j);
                }

                if (datas[i][j - 1] == '1' && datas[i][j] == '1') {
                    union.union(i, j - 1, i , j);
                }
            }
        }

        return union.sets;
    }

    public static class UNION {

        int col;
        int row;
        int sets;
        int[] parents;
        int[] sizes;
        int[] help;

        private UNION(char[][] datas) {
            row = datas.length;
            col = datas[0].length;
            int len = row * col;
            parents = new int[len];
            sizes = new int[len];
            help = new int[len];
            for (int i = 0; i < datas.length; i++) {
                for (int j = 0; j < datas[i].length; j++) {
                    if (datas[i][j] == '1') {
                        int index = getIndex(row, col);
                        parents[index] = index;
                        sizes[index] = 1;
                        sets++;
                    }
                }
            }
        }

        public int findIndex(int index) {
            int helpIndex = 0;
            while (parents[index] != index) {
                help[helpIndex++] = index;
                index = parents[index];
            }
            for (helpIndex--; helpIndex >= 0; helpIndex--) {
                parents[help[helpIndex]] = index;
            }
            return index;
        }

        private void union(int a1, int a2, int b1, int b2) {
            int index1 = getIndex(a1, a2);
            int index2 = getIndex(b1, b2);
            int f1 = findIndex(index1);
            int f2 = findIndex(index2);
            if (f1 != f2) {
                int bigHead = sizes[f1] >= sizes[f2] ? f1 : f2;
                int smallHead = bigHead == f1 ? f2 : f1;
                parents[smallHead] = bigHead;
                sizes[bigHead] += sizes[smallHead];
            }
        }

        public int getIndex(int row, int col) {
            return this.col * row + col;
        }
    }
}
