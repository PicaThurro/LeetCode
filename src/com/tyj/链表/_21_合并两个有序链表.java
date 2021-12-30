package com.tyj.链表;

import com.tyj.ListNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/30 22:48
 */
public class _21_合并两个有序链表 {


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        mergeTwoLists(list1, list2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }else if (list1.val< list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

}
