package com.java.interview.common;/*
 *  @(#)ListNode.java 1.0 2021-06-20
 *
 *             Copyright (c) 2017, YUNXI. All rights reserved.
 *             YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * leekcode206单链表反转中使用
 * @author liaowenhui
 * @date 2021/6/20 16:29
 */
public class ListNode {
    public int date;
    public ListNode next;

    public ListNode(int date) {
        this.date = date;
    }

    public ListNode(int date, ListNode next) {
        this.date = date;
        this.next = next;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
