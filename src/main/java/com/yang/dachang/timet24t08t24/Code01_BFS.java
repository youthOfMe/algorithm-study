package com.yang.dachang.timet24t08t24;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 图的广度优先遍历 -> BFS
 */
public class Code01_BFS {

    public static void main(String[] args) {

    }

    public static void process(Node start) {
        HashSet<Node> nodes = new HashSet<>();
        LinkedList<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(start);
        nodes.add(start);
        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            System.out.println(curNode.value);
            // for (int i = 0; i < curNode.nexts.size(); i++) {
            //     if (!nodes.contains(curNode.nexts.get(i))) {
            //         nodes.add(curNode.nexts.get(i));
            //         nodeQueue.add(curNode.nexts.get(i));
            //     }
            // }
            for (Node next : curNode.nexts) {
                if (!nodes.contains(next)) {
                    nodes.add(next);
                    nodeQueue.add(next);
                }
            }
        }
    }
}
