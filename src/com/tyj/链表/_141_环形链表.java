package com.tyj.链表;

import com.tyj.ListNode;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author : 唐元晋
 * @created 2021/12/15 18:02
 */
public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
