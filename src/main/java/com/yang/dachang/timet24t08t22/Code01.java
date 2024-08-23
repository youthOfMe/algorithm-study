package com.yang.dachang.timet24t08t22;

import java.util.*;

/**
 * hashMap实现岛问题
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(char[][] datas) {
        int row = datas.length;
        int col = datas[0].length;
        Dot[][] dots = new Dot[col][row];
        ArrayList<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                if (datas[i][j] == '1') {
                    Dot dot = new Dot();
                    dotList.add(dot);
                    dots[i][j] = dot;
                }
            }
        }
        UNION<Dot> union = new UNION<>(dotList);

        for (int i = 1; i < col; i++) {
            if (datas[0][i - 1] == '1' && datas[0][i] == '1') {
                union.union(dots[0][i - 1], dots[0][i]);
            }
        }

        for (int i = 1; i < row; i++) {
            if (datas[i - 1][0] == '1' && datas[i][0] == '1') {
                union.union(dots[i - 1][0], dots[i][0]);
            }
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (datas[i][j - 1] == '1' && datas[i][j] == '1') {
                    union.union(dots[i][j - 1], dots[i][j]);
                }

                if (datas[i - 1][j] == '1' && datas[i][j] == '1') {
                    union.union(dots[i - 1][j], dots[i][j]);
                }
            }
        }

        return union.sets;
    }

    public static class Dot {

    }

    public static class Node<T> {
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class UNION<T> {
        private Map<T, Node<T>> dataMap = new HashMap<>();
        private Map<Node<T>, Node<T>> parentMap = new HashMap<>();
        private Map<Node<T>, Integer> sizeMap = new HashMap<>();
        private int sets;

        public UNION(List<T> dataList) {
            int size = dataList.size();
            sets = size;
            for (int i = 0; i < size; i++) {
                T data = dataList.get(i);
                Node<T> dataNode = new Node<>(data);
                dataMap.put(data, dataNode);
                parentMap.put(dataNode, dataNode);
                sizeMap.put(dataNode, 1);
            }
        }

        public Node<T> findHead(Node<T> data) {
            Stack<Node<T>> stack = new Stack<>();
            while (parentMap.get(data) != data) {
                stack.push(parentMap.get(data));
                data = parentMap.get(data);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), data);
            }
            return data;
        }

        public void union(T a, T b) {
            Node<T> nodeA = dataMap.get(a);
            Node<T> nodeB = dataMap.get(b);
            if (nodeA != null && nodeB != null) {
                Node<T> f1 = findHead(nodeA);
                Node<T> f2 = findHead(nodeB);
                if (f1 != f2) {
                    Node<T> bigNode = sizeMap.get(nodeA) >= sizeMap.get(nodeB) ? nodeA : nodeB;
                    Node<T> smallNode = bigNode == nodeA ? nodeB : nodeA;
                    parentMap.put(smallNode, bigNode);
                    sizeMap.put(bigNode, sizeMap.get(smallNode) + sizeMap.get(bigNode));
                    sizeMap.remove(smallNode);
                    sets--;
                }
            }

        }
    }
}
