package com.leetcode.fan.linkList;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/10/12.
 */

public class ReverseLinkList {
    public static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node pre = head; // 上一节点
        Node cur = head.getNext(); // 当前结点
        Node tmp; // 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {
            tmp = cur.getNext();
            cur.setNext(pre); // 反转指针域的指向
            pre = cur; //
            cur = tmp; //
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点   data=1-->data=2-->data=3-->data=4-->data=5-->null
        head.setNext(null);  //否则5还是指向4  导致循环

        return pre;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        System.out.println(a);/*data=1-->data=2-->data=3-->data=4-->data=5-->null*/
        Node reverse = reverse2(a);/*递归方式反转*/
        System.out.println(reverse);/*data=5-->data=4-->data=3-->data=2-->data=1-->null*/
        Node reverse2 = reverse(reverse);/*非递归方式反转（将之前反转后的单链表反转回来）*/
        System.out.println(reverse2);/*data=1-->data=2-->data=3-->data=4-->data=5-->null*/
    }

    private static Node reverse2(Node head) {
        /*如果是空链或者只是单个节点的链表  将直接返回*/
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node reverse = reverse2(head.getNext());/*找到了最后一个   也就是5   当前head为4  reverse为5*/
        head.getNext().setNext(head);/* 1-->2-->3-->4-->5   变为   5-->4  1-->2-->3-->4  此时4指向5  5 也指向4*/
        head.setNext(null);  /*4-->null    5-->4-->null  1-->2-->3-->4 */
        return reverse;    /*返回5-->4-->null*/
    }
}

