package com.yang.dachang.timet24t08t24;

import java.util.*;

/**
 * 拓扑排序
 */
public class Code03 {

    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        ArrayList<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            result.add(curNode);
            for (Node next : curNode.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (next.in == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
