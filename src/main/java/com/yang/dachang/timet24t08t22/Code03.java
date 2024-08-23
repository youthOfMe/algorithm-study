package com.yang.dachang.timet24t08t22;

/**
 * 岛问题扩展2 => 并查集
 */
public class Code03 {

    public static void main(String[] args) {

    }

    public static int getTarget(int m, int n, int[][] positions) {
        return 1;
    }

    public static class UNION {
        private int[] parents;
        private int[] sizes;
        private int[] help;
        private final int row;
        private final int col;
        private int sets = 0;

        public UNION(int m, int n) {
            row = m;
            col = n;
            int len = col * row;
            parents = new int[len];
            sizes = new int[len];
            help = new int[len];
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

        public void union(int a1, int a2, int b1, int b2) {
            if (a1 < 0 || a1 == row || a2 < 0 || a2 == col || b1 < 0 || b1 == row || b2 < 0 || b2 == col) {
                return;
            }

            int index1 = getIndex(a1, a2);
            int index2 = getIndex(b1, b2);
            if (sizes[index1] == 0 || sizes[index2] == 0) {
                return;
            }
            int f1 = findHead(index1);
            int f2 = findHead(index2);
            if (f1 != f2) {
                int bigHead = sizes[f1] >= sizes[f2] ? f1 : f2;
                int smallHead = bigHead == f1 ? f2 : f1;
                parents[smallHead] = bigHead;
                sizes[bigHead] += sizes[smallHead];
                sets--;
            }
        }

        public int connect(int r, int c) {
            int index = getIndex(r, c);
            if (sizes[index] != 0) {
                parents[index] = index;
                sizes[index] = 1;
                sets++;
                union(r - 1, c, r, c);
                union(r, c - 1, r, c);
                union(r, c + 1, r, c);
                union(r + 1, c, r, c);
            }
            return sets;
        }

        private int getIndex(int i, int j) {
            return i * col + j;
        }
    }
}
