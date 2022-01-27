package com.tyj.链表;

import com.tyj.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/sort-list/
 * @author : 唐元晋
 * @created 2022/1/27 14:31
 */
public class _148_排序链表 {


    /**
     * 自己写的垃圾方法
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        List<Integer> list=new ArrayList<>();

        ListNode tail=head;
        while (tail!=null){
            list.add(tail.val);
            tail=tail.next;
        }
        tail=head;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer integer : list) {
            tail.val=integer;
            tail=tail.next;
        }
        return head;
    }

}
