package com.yang.dachang.timet24t08t19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 实现并查集
 */
public class Code01 {

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

        public UNION(List<T> list) {
            for (int i = 0; i < list.size(); i++) {
                Node<T> node = new Node<>(list.get(i));
                dataMap.put(list.get(i), node);
                parentMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<T> findHead(Node<T> node) {
            Stack<Node<T>> stack = new Stack<>();
            Node<T> curNode = node;
            while (parentMap.get(curNode) != curNode) {
                stack.push(curNode);
                curNode = parentMap.get(curNode);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), curNode);
            }
            return curNode;
        }

        public boolean isSameSet(T a, T b) {
            Node<T> nodeA = dataMap.get(a);
            Node<T> nodeB = dataMap.get(b);
            if (nodeA != null && nodeB != null) {
                return findHead(nodeA) == findHead(nodeB);
            }
            return false;
        }

        public void union(T a, T b) {
            if (dataMap.containsKey(a) && dataMap.containsKey(b)) {
                Node<T> aNode = findHead(dataMap.get(a));
                Node<T> bNode = findHead(dataMap.get(b));
                if (aNode != bNode) {
                    Node<T> bigNode = sizeMap.get(aNode) > sizeMap.get(bNode) ? aNode : bNode;
                    Node<T> smallNode = bigNode == aNode ? bNode : aNode;
                    parentMap.put(smallNode, bigNode);
                    sizeMap.put(bigNode, sizeMap.get(smallNode) + sizeMap.get(bigNode));
                    sizeMap.remove(smallNode);
                }
            }
        }
    }
}
