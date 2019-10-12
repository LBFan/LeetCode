package com.leetcode.fan.linkList;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class Node {
    private Node next;
    private int data;
    public Node(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "-->"+next;
    }
}

