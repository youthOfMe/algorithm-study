package com.yang.dachang.timet24t08t21;

import java.util.*;

public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(char[][] datas) {
        int row = datas.length;
        int col = datas[0].length;
        Dot[][] dots = new Dot[row][col];
        ArrayList<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                if (datas[i][j] == '1') {
                    dots[i][j] = new Dot();
                    dotList.add(dots[i][j]);
                }
            }
        }

        UNION union = new UNION(dotList);
        for (int i = 1; i < datas[0].length; i++) {
            if (datas[0][i - 1] == '1' && datas[0][i] == '1') {
                union.union(dots[0][i - 1], dots[0][i]);
            }
        }

        for (int i = 1; i < datas.length; i++) {
            if (datas[i - 1][0] == '1' && datas[i][0] == '1') {
                union.union(dots[i - 1][0], dots[i][0]);
            }
        }

        for (int i = 1; i < datas.length; i++) {
            for (int j = 1; j < datas[0].length; j++) {
                if (datas[i - 1][j] == '1' && datas[i][j] == '1') {
                    union.union(dots[i - 1][j], dots[i][j]);
                }

                if (datas[i][j - 1] == '1' && datas[i][j] == '1') {
                    union.union(dots[i][j - 1], dots[i][j]);
                }
            }
        }

        return union.sets;
    }

    public static class Dot {

    }

    public static class Node {
        private Dot value;

        public Node(Dot value) {
            this.value = value;
        }
    }

    public static class UNION {
        private Map<Dot, Node> nodes;
        private Map<Node, Node> parents;
        private Map<Node, Integer> sizeMap;
        private int sets;

        public UNION(List<Dot> list) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            sets = list.size();
            for (int i = 0; i < list.size(); i++) {
                Dot dot = list.get(i);
                Node node = new Node(list.get(i);
                nodes.put(dot, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findHead(Node node) {
            Stack<Node> stack = new Stack<>();
            while (parents.get(node) != node) {
                stack.push(node);
                node = parents.get(node);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(Dot a, Dot b) {
            Node nodeA = nodes.get(a);
            Node nodeB = nodes.get(b);
            if (nodeA != null && nodeB != null) {
                return findHead(nodeA) == findHead(nodeB);
            }
            return false;
        }

        public void union(Dot a, Dot b) {
            Node nodeA = nodes.get(a);
            Node nodeB = nodes.get(b);
            if (nodeA != null && nodeB != null) {
                Node findA = findHead(nodeA);
                Node findB = findHead(nodeB);
                if (findA != findB) {
                    Node bigNode = sizeMap.get(findA) >= sizeMap.get(findB) ? findA : findB;
                    Node smallNode = bigNode == findA ? findB : findA;
                    parents.put(smallNode, bigNode);
                    sizeMap.put(bigNode, sizeMap.get(bigNode) + sizeMap.get(smallNode));
                    sizeMap.remove(smallNode);
                    sets--;
                }
            }
        }
    }
}
