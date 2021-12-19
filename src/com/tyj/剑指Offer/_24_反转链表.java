package com.tyj.剑指Offer;

import com.tyj.ListNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @author : 唐元晋
 * @created 2021/12/19 21:21
 */
public class _24_反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (head!=null){
            head=head.next;
            curr.next=prev;
            prev=curr;
            curr=head;
        }
        return prev;
    }

}
