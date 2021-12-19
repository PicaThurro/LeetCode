package com.tyj;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/19 21:26
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
