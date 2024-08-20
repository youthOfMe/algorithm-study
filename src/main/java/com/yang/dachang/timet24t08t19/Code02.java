package com.yang.dachang.timet24t08t19;

/**
 * 数组实现并查集
 */
public class Code02 {

    public class UNION {
        private int[] parents;
        private int[] sizes;
        private int[] help;
        private int sets;

        private UNION(int[] dataList) {
            final int N = dataList.length;
            sets = N;
            parents = new int[N];
            sizes = new int[N];
            help = new int[N];
        }

        private int findHead(int data) {
            int index = 0;
            int curData = data;
            while (parents[data] != data) {
                help[index++] = curData;
                curData = parents[curData];
            }
            for (index--; index >= 0; index--) {
                parents[help[index]] = curData;
            }

            return curData;
        }

        private void unoin(int a, int b) {
            int f1 = findHead(a);
            int f2 = findHead(b);
            if (f1 != f2) {
                int bigData = sizes[f1] > sizes[f2] ? f1 : f2;
                int smallData = bigData == sizes[f1] ? f2 : f1;
                parents[smallData] = bigData;
                sizes[bigData] = sizes[bigData] + sizes[smallData];
                sets--;
            }
        }
    }
}
