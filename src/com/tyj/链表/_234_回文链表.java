package com.tyj.链表;

import com.tyj.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author : 唐元晋
 * @created 2022/1/22 16:04
 */
public class _234_回文链表 {

    /**
     * 遍历一次将元素放入数组
     * 然后数组采用双指针法来比较，如有不同直接返回false
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;
    }

    /**
     * 遍历一次将元素压入栈
     * 再遍历一次将栈中元素依次弹出比较，如果有不相同的元素，直接返回false
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode a=head;
        Stack<Integer> stack=new Stack<>();
        while (a != null) {
            stack.push(a.val);
            a = a.next;
        }
        while (head != null) {
            if (stack.pop()!= head.val){
                return false;
            }
            head = head.next;
        }

        return true;
    }

}
