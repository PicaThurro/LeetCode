package com.tyj.剑指Offer;

import com.tyj.ListNode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author : 唐元晋
 * @created 2021/12/19 21:17
 */
public class _06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] result=new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=stack.pop();
        }
        return result;
    }

}
