package com.yang.dachang.timet24t08t24;

import java.util.HashSet;
import java.util.Stack;

/**
 * 宽度优先遍历
 */
public class Code02_DFS {

    public static void dfs(Node start) {
        if (start == null) return;
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        set.add(start);
        stack.push(start);
        System.out.println(start.value);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    stack.push(node);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
