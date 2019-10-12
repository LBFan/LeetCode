package com.leetcode.fan.linkList;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class DeleteNode {
    private static Node deleteNode(Node head, int n) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.getNext();
        }
        if (fast == null) {
            return slow.getNext();
        }
        while (fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(6);
        Node b = new Node(7);
        Node c = new Node(8);
        Node d = new Node(9);
        Node e = new Node(10);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        int n = 3;
        Node node = deleteNode(a, n);
        System.out.println(node);
    }
}

