package com.yang.dachang.timet24t08t19;

/**
 * 力扣原题: friend-circle
 */
public class Code03 {

    public static void main(String[] args) {
        System.out.println(findCircleNum(null));
    }

    public static int findCircleNum(int[][] M) {
        M = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        UNION union = new UNION(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        return union.sets;
    }

    public static class UNION {
        private int[] parents;
        private int[] sizes;
        private int[] help;
        private int sets;

        public UNION(int N) {
            sets = N;
            parents = new int[N];
            sizes = new int[N];
            help = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        private int findHead(int data) {
            int curData = data;
            int index = 0;
            while (parents[curData] != curData) {
                help[index++] = curData;
                curData = parents[curData];
            }
            for (index--; index >= 0; index--) {
                parents[help[index]] = curData;
            }
            return curData;
        }

        private void union(int a, int b) {
            int f1 = findHead(a);
            int f2 = findHead(b);
            if (f1 != f2) {
                int bigData = sizes[f1] >= sizes[f2] ? f1 : f2;
                int smallData = f1 == bigData ? f2 : f1;
                parents[smallData] = bigData;
                sizes[bigData] += sizes[smallData];
                sets--;
            }
        }
    }
}
