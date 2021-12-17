package com.tyj.链表;

import com.tyj.ListNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author : 唐元晋
 * @created 2021/12/15 17:51
 */
public class _206_反转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = reverseList(head);
        System.out.println("reverseList = " + reverseList.val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while (head != null) {
            head = head.next;
            next.next = prev;
            prev = next;
            next = head;
        }
        return prev;
    }

    //递归
    /*public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }*/

}
