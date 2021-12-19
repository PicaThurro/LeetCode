package com.tyj.剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author : 唐元晋
 * @created 2021/12/19 20:57
 */
public class _30_包含min函数的栈 {

    Stack<Integer> A, B;
    public _30_包含min函数的栈() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }
    public void pop() {
        if(A.pop().equals(B.peek())) {
            B.pop();
        }
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
