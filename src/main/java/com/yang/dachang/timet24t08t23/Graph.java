package com.yang.dachang.timet24t08t23;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图结构
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
