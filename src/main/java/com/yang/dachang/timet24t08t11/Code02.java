package com.yang.dachang.timet24t08t11;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表新题3
 */
public class Code02 {

    public static void main(String[] args) {
        Node02 node = new Node02();
        node.value = 1;
        Node02 node1 = new Node02();
        node.next = node1;
        node1.value = 2;
        Node02 node2 = new Node02();
        node2.value = 3;
        node.rand = node2;
        node1.next = node2;
        node1.rand = node;

    }

    public static Node02 getTarget(Node02 node) {
        Node02 head = node;
        Map<Node02, Node02> nodeMap = new HashMap<>();
        while (node != null) {
            Node02 nodek = new Node02();
            nodek.value = node.value;
            nodeMap.put(node, nodek);
            node = node.next;
        }
        node = head;
        while (node != null) {
            nodeMap.get(node).next = nodeMap.get(node.next);
            nodeMap.get(node).rand = nodeMap.get(node.rand);
            node = node.next;
        }
        return nodeMap.get(head);
    }
}
