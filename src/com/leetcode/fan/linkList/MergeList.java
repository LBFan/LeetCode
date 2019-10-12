package com.leetcode.fan.linkList;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class MergeList {
    private static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node res = new Node(Integer.MAX_VALUE);
        Node tmp = res;
        Node p = head1;
        Node q = head2;
        while (p != null && q != null) {
            if (p.getData() <= q.getData()) {
                tmp.setNext(p);
                tmp = tmp.getNext();
                p = p.getNext();
            } else if (q.getData() < p.getData()) {
                tmp.setNext(q);
                tmp = tmp.getNext();
                q = q.getNext();
            }
        }
        while (p != null) {
            tmp.setNext(p);
            p = p.getNext();
            tmp = tmp.getNext();
        }
        while (q != null) {
            tmp.setNext(q);
            tmp = tmp.getNext();
            q = q.getNext();
        }
        return res.getNext();
    }

    // 完美解答：递归
    private static Node merge02(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node res;
        //分治思想，每次拿一个小的出来，每次的动作相同
        if (head1.getData() <= head2.getData()) {
            res = head1;
            res.setNext(merge02(head1.getNext(), head2));
        } else {
            res = head2;
            res.setNext(merge02(head1, head2.getNext()));
        }
//        res.setNext(head1.getData() > head2.getData() ? merge02(head1, head2.getNext()) : merge02(head1.getNext(), head2)); //l1.val > l2.val ? mergeTwoLists(l1, l2.next) : mergeTwoLists(l1.next, l2)
        return res;
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
        Node p = new Node(1);
        Node q = new Node(2);
        Node r = new Node(3);
        Node s = new Node(4);
        Node t = new Node(5);
        p.setNext(q);
        q.setNext(r);
        r.setNext(s);
        s.setNext(t);

        Node node = merge02(a, p);
        System.out.println(node);

    }
}

