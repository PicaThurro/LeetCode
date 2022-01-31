package com.tyj.设计;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/lru-cache/
 * @author : 唐元晋
 * @created 2022/1/31 16:12
 */
public class _146_LUR缓存 {

    Map<Integer,Integer> element;
    Queue<Integer> keyQueue;
    private int capacity;

    public _146_LUR缓存(int capacity) {
        element=new HashMap<>();
        this.capacity=capacity;
        keyQueue=new LinkedList<>();
    }

    public int get(int key) {
        if (!element.containsKey(key)){
            return -1;
        }
        Integer integer = element.get(key);
        keyQueue.remove(key);
        keyQueue.offer(key);
        return integer;
    }

    public void put(int key, int value) {
        if (!element.containsKey(key)){
            checkCapacity();
            keyQueue.offer(key);
            element.put(key,value);
        }else {
            keyQueue.remove(key);
            keyQueue.offer(key);
            element.put(key,value);
        }
    }

    private void checkCapacity(){
        if (capacity==element.size()){
            Integer key = keyQueue.poll();
            element.remove(key);
        }
    }

}
