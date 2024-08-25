package com.yang.dachang.timet24t08t25;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 */
public class Code02_DFS {

    public void dfs(Node start) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> result = new HashSet<>();
        stack.push(start);
        result.add(start);
        System.out.println(start.value);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            for (Node next : curNode.nexts) {
                if (!result.contains(next)) {
                    System.out.println(next.value);
                    stack.push(next);
                    result.add(next);
                    break;
                }
            }
        }
    }
}
