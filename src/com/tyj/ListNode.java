package com.tyj;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/15 17:51
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
