package com.tyj.剑指Offer;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author : 唐元晋
 * @created 2021/12/19 20:39
 */
public class _09_用两个栈实现队列 {

    private int size = 0;
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public _09_用两个栈实现队列() {

    }

    public void appendTail(int value) {
        inStack.push(value);
        size++;
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            for (int i = 0; i < this.size; i++) {
                outStack.push(inStack.pop());
            }
        }
        size--;
        return outStack.pop();
    }

}
