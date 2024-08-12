package com.yang.dachang.timet24t08t11;

import com.yang.dachang.timet24t08t10.Node;

/**
 * 链表新题2
 */
public class Code01 {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node.next = node2;
        Node<Integer> node3 = new Node<>(3);
        node2.next = node3;
        Node<Integer> node4 = new Node<>(4);
        node3.next = node4;
        Node<Integer> node5 = new Node<>(5);
        node4.next = node5;
        Node<Integer> node6 = new Node<>(8);
        node5.next = node6;
        Node<Integer> node7 = new Node<>(1);
        node6.next = node7;
        node = getIntegerarget(node, 2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static Node<Integer> getIntegerarget(Node<Integer> node, int k) {
        Node<Integer> smallHeadPoint = null;
        Node<Integer> smallTailPoint = null;
        Node<Integer> equalHeadPoint = null;
        Node<Integer> equalTailPoint = null;
        Node<Integer> bigHeadPoint = null;
        Node<Integer> bigTailPoint = null;

        while (node != null) {
            Node<Integer> next = node.next;
            if (node.value < k) {
                if (smallHeadPoint == null && smallTailPoint == null) {
                    smallHeadPoint = node;
                    smallTailPoint = node;
                } else {
                    smallTailPoint.next = node;
                    smallTailPoint = node;
                    smallTailPoint.next = null;
                }
            } else if (node.value == k) {
                if (equalHeadPoint == null && equalTailPoint == null) {
                    equalHeadPoint = node;
                    equalTailPoint = node;
                } else {
                    equalTailPoint.next = node;
                    equalTailPoint = node;
                    equalTailPoint.next = null;
                }
            } else {
                if (bigHeadPoint == null && bigTailPoint == null) {
                    bigHeadPoint = node;
                    bigTailPoint = node;
                } else {
                    bigTailPoint.next = node;
                    bigTailPoint = node;
                }
                bigTailPoint.next = null;
            }
            node = next;
        }

        smallTailPoint.next = equalHeadPoint;
        equalTailPoint.next = bigHeadPoint;
        return smallHeadPoint;
    }
}


