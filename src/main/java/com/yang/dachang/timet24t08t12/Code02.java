package com.yang.dachang.timet24t08t12;

import java.util.HashSet;

public class Code02 {

    public static void main(String[] args) throws InterruptedException {
        // 创建第一个链表，长度为3
        Node02 list1Head = new Node02(1); // 头节点
        Node02 list1Node2 = new Node02(2); // 第二个节点
        Node02 list1Node3 = new Node02(3); // 第三个节点

        list1Head.next = list1Node2; // 连接头节点和第二个节点
        list1Node2.next = list1Node3; // 连接第二个节点和第三个节点

        // 创建第二个链表，长度为5
        Node02 list2Head = new Node02(4); // 头节点
        Node02 list2Node2 = new Node02(5);
        Node02 list2Node3 = new Node02(6);
        Node02 list2Node4 = new Node02(7);
        Node02 list2Node5 = new Node02(8);

        list2Head.next = list2Node2; // 连接头节点和第二个节点
        list2Node2.next = list2Node3;
        list2Node3.next = list2Node4;
        list2Node4.next = list2Node5;

        // 使第一个链表的第二个节点的next指向第二个链表的头节点
        list1Node2.next = list2Node2;

        System.out.println(getTarget(list1Head, list2Head).value);
    }

    public static Node02 getTarget(Node02 node1, Node02 node2) {
        if (node1 == null || node2 == null || node1.next == null || node2.next == null) {
            return null;
        }

        Node02 loop1 = isHasCircle(node1);
        Node02 loop2 = isHasCircle(node2);
        if (loop1 == null && loop2 == null) {
            return noLoop(node1, node2);
        }

        return null;
    }

    public static Node02 hasLoop(Node02 node1, Node02 node2, Node02 loop1, Node02 loop2) {
        Node02 curNode1 = node1;
        Node02 curNode2 = node2;

        if (loop1 == loop2) {
            int n = 0;
            while (curNode1.next != loop1.next) {
                curNode1 = curNode1.next;
                n++;
            }
            while (curNode2.next != loop2.next) {
                curNode2 = curNode2.next;
                n--;
            }
            if (curNode2 != curNode1) {
                return null;
            }
            // curNode1为长的
            curNode1 = n > 0 ? node1 : node2;
            curNode2 = curNode1 == node1 ? node2 : node1;
            n = Math.abs(n);
            while (n > 0) {
                n--;
                curNode1 = curNode1.next;
            }

            while (curNode1 != curNode2) {
                curNode1 = curNode1.next;
                curNode2 = curNode2.next;
            }

            return curNode2;
        } else {
            curNode1 = curNode1.next;
            while (curNode1 != loop2) {
                if (curNode1 == curNode2) {
                    return curNode1;
                }
                curNode1 = curNode1.next;
            }
            return null;
        }
    }

    public static Node02 noLoop(Node02 node1, Node02 node2) {
        Node02 curNode1 = node1;
        Node02 curNode2 = node2;

        int n = 0;
        while (curNode1.next != null) {
            curNode1 = curNode1.next;
            n++;
        }
        while (curNode2.next != null) {
            curNode2 = curNode2.next;
            n--;
        }
        if (curNode2 != curNode1) {
            return null;
        }
        // curNode1为长的
        curNode1 = n > 0 ? node1 : node2;
        curNode2 = curNode1 == node1 ? node2 : node1;
        n = Math.abs(n);
        while (n > 0) {
            n--;
            curNode1 = curNode1.next;
        }

        while (curNode1 != curNode2) {
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }

        return curNode2;
    }

    /**
     * 查看是否是一个环
     * @param node
     * @return
     */
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
}
