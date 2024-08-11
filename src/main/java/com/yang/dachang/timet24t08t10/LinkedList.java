package com.yang.dachang.timet24t08t10;

/**
 * 实现链表和几个方法
 */
public class LinkedList<T> {

    public Node<T> head;
    public Node<T> quickPoint;
    public Node<T> slowPoint;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    /**
     * 获取链表的中点
     * 奇数个: 中点
     * 偶数个: 上中点
     *
     * @return
     */
    public Node<T> getMiddleOne() {
        quickPoint = head;
        slowPoint = head;
        if (head == null) {
            return null;
        }
        // 处理1 - 2个问题
        if (head.next == null || (quickPoint = (slowPoint = head.next).next) == null) {
            return head;
        }

        // 设置壁垒为最后一个
        while (quickPoint != null && quickPoint.next != null) {
            quickPoint = quickPoint.next.next;
            if (quickPoint == null) {
                return slowPoint;
            }
            slowPoint = slowPoint.next;
        }
        return slowPoint;
    }

    /**
     * 获取链表的重点
     * 奇数个: 中点
     * 偶数个: 下中点
     *
     * @return
     */
    public Node<T> getMiddleTwo() {
        quickPoint = head;
        slowPoint = head;
        if (head == null) {
            return null;
        }
        // 处理1 - 2个问题
        if (head.next == null || (quickPoint = (slowPoint = head.next).next) == null) {
            return head;
        }

        // 设置壁垒为最后一个
        while (quickPoint != null && quickPoint.next != null) {
            quickPoint = quickPoint.next.next;
            slowPoint = slowPoint.next;
            if (quickPoint == null) {
                return slowPoint;
            }
        }
        return slowPoint;
    }

    /**
     * 获取链表的重点
     * 奇数个: 中点前一个
     * 偶数个: 上中点前一个
     *
     * @return
     */
    public Node<T> getMiddleThree() {
        quickPoint = head;
        slowPoint = head;
        if (head == null) {
            return null;
        }
        // 处理1 - 2个问题
        if (head.next == null || (quickPoint = (quickPoint = head.next).next) == null) {
            return head;
        }

        // 设置壁垒为最后一个
        while (quickPoint.next != null && quickPoint.next.next != null && quickPoint.next.next.next != null) {
            quickPoint = quickPoint.next.next;
            if (quickPoint.next.next == null) {
                return slowPoint;
            }

            slowPoint = slowPoint.next;
        }
        return slowPoint;
    }

    /**
     * 获取链表的重点
     * 奇数个: 中点下一个
     * 偶数个: 下中点下一个
     *
     * @return
     */
    public Node<T> getMiddleFour() {
        quickPoint = head;
        slowPoint = head;
        if (head == null) {
            return null;
        }
        // 处理1 - 2个问题
        if (head.next == null || (quickPoint = (slowPoint = head.next).next) == null) {
            return head;
        }

        // 设置壁垒为最后一个
        while (quickPoint != null && quickPoint.next != null) {
            quickPoint = quickPoint.next.next;
            slowPoint = slowPoint.next;
            if (quickPoint == null) {
                return slowPoint.next;
            }
        }
        return slowPoint.next;
    }
}
