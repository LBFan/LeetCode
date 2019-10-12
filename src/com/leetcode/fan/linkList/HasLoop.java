package com.leetcode.fan.linkList;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class HasLoop {
    // 双指针法
    private static boolean hasLoop(Node head) {
        if (head == null) {
            return false;
        }
        Node p = head.getNext();
        Node q = head.getNext().getNext();

        while (q != null && q.getNext() != null) {
            p = p.getNext();
            q = q.getNext().getNext();
            if (p == q) {
                return true;
            }
        }
        return false;
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
//        e.setNext(c);
        boolean b1 = hasLoop(a);
        System.out.println(b1);
    }
}

