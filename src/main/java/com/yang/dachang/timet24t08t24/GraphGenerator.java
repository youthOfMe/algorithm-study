package com.yang.dachang.timet24t08t24;

/**
 * 生成图
 */
public class GraphGenerator {

    public Graph generator(int[][] datas) {
        final int N = datas.length;
        Graph graph = new Graph();
        for (int i = 0; i < N; i++) {
            int weight = datas[i][0];
            int from = datas[i][1];
            int to = datas[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Edge edge = new Edge(weight);
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
