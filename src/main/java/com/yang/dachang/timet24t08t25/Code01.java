package com.yang.dachang.timet24t08t25;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 图的广度有限遍历BFS
 */
public class Code01 {

    public void bfs(Node start) {
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
