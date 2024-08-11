package com.yang.dachang.timet24t08t10;
public class Code01 {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node.next = node2;
        Node<Integer> node3 = new Node<>(3);
        node2.next = node3;
        Node<Integer> node4 = new Node<>(4);
        node3.next = node4;
        LinkedList<Integer> integerLinkedList = new LinkedList<>(node);
        Node<Integer> middleOne = integerLinkedList.getMiddleOne();
        System.out.println(middleOne.value);
        Node<Integer> middleTwo = integerLinkedList.getMiddleTwo();
        System.out.println(middleTwo.value);
        Node<Integer> middleThree = integerLinkedList.getMiddleThree();
        System.out.println(middleThree.value);
        Node<Integer> middleFour = integerLinkedList.getMiddleFour();
        System.out.println(middleFour.value);
    }
}
