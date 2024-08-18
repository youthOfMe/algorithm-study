package com.yang.dachang.timet24t08t18;

import java.util.HashMap;
import java.util.List;
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

    public static class UnionFindSet<T> {
        public HashMap<T, Node<T>> dataMap = new HashMap<>();
        public HashMap<Node<T>, Node<T>> parentMap = new HashMap<>();
        public HashMap<Node<T>, Integer> sizeMap = new HashMap<>();

        public UnionFindSet(List<T> dataList) {
            for (int i = 0; i < dataList.size(); i++) {
                T data = dataList.get(i);
                Node<T> curNode = new Node<>(data);
                dataMap.put(data, curNode);
                parentMap.put(curNode, curNode);
                sizeMap.put(curNode, 1);
            }
        }

        public Node<T> findHead(Node<T> node) {
            Node<T> curNode = node;
            Stack<Node<T>> nodeStack = new Stack<>();
            while (parentMap.get(curNode) != curNode) {
                curNode = parentMap.get(curNode);
                nodeStack.push(curNode);
            }
            while (!nodeStack.isEmpty()) {
                Node<T> swapNode = nodeStack.pop();
                parentMap.put(swapNode, curNode);
            }
            return curNode;
        }

        public Boolean isSameSet(T a, T b) {
            if (dataMap.containsKey(a) && dataMap.containsKey(b)) {
                return findHead(dataMap.get(a)) == findHead(dataMap.get(b));
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
                    sizeMap.put(bigNode, sizeMap.get(bigNode) + sizeMap.get(smallNode));
                    sizeMap.remove(smallNode);
                }
            }
        }
    }
}
