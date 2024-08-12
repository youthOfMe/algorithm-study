package com.yang.dachang.timet24t08t10;

/**
 * 链表新题
 */
public class Code03 {
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
        node = isHuiWen(node);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static <T> Node<T> isHuiWen(Node<T> node) {
        Node<T> shou = node;
        if (node.next == null) {
            return node;
        }

        Node<T> quickPoint = node;
        Node<T> slowPoint = node;
        while (quickPoint.next != null) {
            quickPoint = quickPoint.next;
            if (quickPoint.next == null) {
                break;
            }
            quickPoint = quickPoint.next;
            slowPoint = slowPoint.next;
        }

        quickPoint = slowPoint.next;
        Node<T> nodeK = null;
        while (quickPoint != null) {
            nodeK = quickPoint.next;
            quickPoint.next = slowPoint;
            slowPoint = quickPoint;
            quickPoint = nodeK;
        }
        quickPoint = node;
        while (slowPoint.next != quickPoint && quickPoint.next != slowPoint.next) {
            node = quickPoint.next;
            quickPoint.next = slowPoint;
            quickPoint = node;
            node = slowPoint.next;
            slowPoint.next = quickPoint;
            slowPoint = node;
        }
        if (slowPoint.next == quickPoint) {
            quickPoint.next = slowPoint;
            slowPoint.next = null;
        }
        if (slowPoint.next == quickPoint.next) {
            node = quickPoint.next;
            quickPoint.next = slowPoint;
            node.next = null;
        }

        return shou;
    }
}
