package com.yang.dachang.timet24t08t25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序
 */
public class Code03 {

    public static List<Node> getTarget(Graph graph) {
        ArrayList<Node> resultList = new ArrayList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        for (Node value : graph.nodes.values()) {
            inMap.put(value, value.in);
            if (value.in == 0) {
                queue.add(value);
            }
        }
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            resultList.add(curNode);
            for (Node next : curNode.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return resultList;
    }
}
