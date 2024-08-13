package com.yang.dachang.timet24t08t12;


/**
 * 链表新题3 -> 非容器实现
 */
public class Code01 {

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

        Node02 target = getTarget(node);
        while (target != null) {
            System.out.println(target.value);
            target = target.next;
        }
    }

    public static Node02 getTarget(Node02 node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node02 curNode = node;
        while (curNode != null) {
            Node02 copyNode = new Node02();
            copyNode.value = curNode.value;
            copyNode.next = curNode.next;
            curNode.next = copyNode;
            curNode = copyNode.next;
        }


        curNode = node.next;
        Node02 res = curNode;
        while (curNode.next != null) {
            curNode.rand = node.rand;
            node.next = curNode.next;
            node = node.next;
            curNode.next = node.next;
            curNode = curNode.next;

        }


        return res;
    }
}
