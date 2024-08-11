package com.yang.dachang.timet24t08t10;

/**
 * 有限几个变量求是不是回文链表
 */
public class Code02 {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        // Node<Integer> node2 = new Node<>(1);
        // node.next = node2;
        // Node<Integer> node3 = new Node<>(1);
        // node2.next = node3;
        // Node<Integer> node4 = new Node<>(1);
        // node3.next = node4;
        System.out.println(isHuiWen(node));
    }

    public static <T> boolean isHuiWen(Node<T> node) {
        if (node.next == null) {
            return true;
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

        while (quickPoint != slowPoint && quickPoint.next != slowPoint) {
            if (quickPoint.value != slowPoint.value) {
                return false;
            }
            quickPoint = quickPoint.next;
            slowPoint = slowPoint.next;
        }
        if (quickPoint.value != slowPoint.value) {
            return false;
        }
        return true;
    }
}
