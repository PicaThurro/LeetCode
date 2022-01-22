package com.tyj.链表;

import com.tyj.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author : 唐元晋
 * @created 2022/1/22 15:07
 */
public class _160_相交链表 {

    /**
     * 官方题解 双指针
     * 当链表headA和headB都不为空时,两个链表才可能相交。因此首先判断链表headA和headB是否为空
     * 如果其中至少有一个链表为空，则两个链表一定不相交，返回null
     * 当两个链表都不为空时，创建两个指针p1和p2，初始时分别指向两个链表的头结点headA和headB
     * 然后将两个指针一次遍历链表的每个节点：
     *          1.每步操作需要同时更新指针p1和p2
     *          2.如果指针p1不为空，则将指针p1移到下一个节点；p2同理
     *          3.如果指针p1为空，则将指针p1移到链表headB的头结点。如果指针p2为空，则将指针p2移到链表headA的头结点
     *          4.当指针p1和p2指向同一个节点或者都为空时，返回它们指向的节点（如果是null的话，说明两个链表不相交）
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if (headA==null||headB==null){
           return null;
       }
       ListNode p1=headA;
       ListNode p2=headB;
       while (p1!=p2){
           p1=p1!=null?p1.next:headB;
           p2=p2!=null?p2.next:headA;
       }
       return p1;
    }

}
