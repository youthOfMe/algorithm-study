package com.yang.dachang.timet24t08t12;

import java.util.HashSet;

public class Code02 {

    public static void main(String[] args) {

    }

    public static Node02 isHasCircleSet(Node02 node) {
        HashSet<Node02> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    public static Node02 isHasCircle(Node02 node) {
        if (node.next == null || node.next.next == null) {
            return null;
        }
        Node02 quickNode = node.next.next;
        Node02 slowNode = node.next;
        while (quickNode != slowNode) {
            if (quickNode.next == null || quickNode.next.next == null) {
                return null;
            }
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }

        quickNode = node;
        while (quickNode != slowNode) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        return quickNode;
    }
}
