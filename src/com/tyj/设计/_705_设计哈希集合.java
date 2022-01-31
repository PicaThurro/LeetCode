package com.tyj.设计;


import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/design-hashset/
 * @author : 唐元晋
 * @created 2022/1/29 16:42
 */
public class _705_设计哈希集合 {

    public class ListNode {
        public int val;
        public com.tyj.ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, com.tyj.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode[] element;
    private static final int CAPACITY=32;

    public _705_设计哈希集合() {
        element= new ListNode[CAPACITY];
    }

    public void add(int key) {
        checkCapacity(key);
        element[key]=new ListNode(key);
    }

    public void remove(int key) {
        if (checkIndex(key)){
            return;
        }
        element[key]=null;
    }

    public boolean contains(int key) {
        if (checkIndex(key)){
            return false;
        }
        return element[key]!=null;
    }

    private boolean checkIndex(int key){
        return key >= element.length;
    }

    private void checkCapacity(int key){
        if (key>=element.length){
            element= Arrays.copyOf(element,key+10);
        }
    }

}
