package com.yang.dachang.timet24t08t19;

// 力扣原题
public class Code04 {

    public static void main(String[] args) {
        System.out.println(getTarget(null));
    }

    public static int getTarget(int[][] M) {
        M = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int N = M.length;
        UNION union = new UNION(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        return union.sets;
    }

    public static class UNION {
        int[] parents;
        int[] sizes;
        int[] help;
        int sets = 0;

        public UNION(int N) {
            parents = new int[N];
            sizes = new int[N];
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int findHead(int data) {
            int curIndex = 0;
            while (parents[data] != data) {
                help[curIndex++] = data;
                data = parents[data];
            }
            for (curIndex--; curIndex >= 0; curIndex--) {
                parents[help[curIndex]] = data;
            }
            return data;
        }

        public void union(int a, int b) {
            int f1 = findHead(a);
            int f2 = findHead(b);
            if (f1 != f2) {
                int bigData = sizes[f1] >= sizes[f2] ? f1 : f2;
                int smallData = bigData == f1 ? f2 : f1;
                parents[smallData] = bigData;
                sizes[bigData] += sizes[smallData];
                sets--;
            }
        }
    }
}
