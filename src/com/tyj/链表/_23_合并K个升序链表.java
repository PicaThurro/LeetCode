package com.tyj.链表;

import com.tyj.ListNode;

import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @author : 唐元晋
 * @created 2022/1/16 16:28
 */
public class _23_合并K个升序链表 {

    /**
     * 优先级队列
     * 先遍历将所有链表的val存入队列中
     * 每次队列出队都是最小的val
     * 在队列不为空的情况下，一直循环出队，然后作为值给node.next创建新节点
     * 当前的root为哑结点，真正的头结点是root.next
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.offer(list.val);
                list = list.next;
            }
        }
        ListNode tail;
        ListNode root = tail = new ListNode();
        while(!priorityQueue.isEmpty()){
            tail.next = new ListNode(priorityQueue.poll());
            tail = tail.next;
        }
        return root.next;
    }

}
