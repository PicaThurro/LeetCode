package com.tyj.栈;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/min-stack/
 * @author : 唐元晋
 * @created 2022/1/22 14:26
 */
public class _155_最小栈 {

    private List<Integer> list;
    private List<Integer> min;
    private int size;

    public _155_最小栈() {
        list=new ArrayList<>();
        min=new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        min.add(val);
        min.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return -1;
                }else if (o1.equals(o2)){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
        size++;
    }

    public void pop() {
        Integer remove = list.remove(--size);
        min.remove(remove);
    }

    public int top() {
        return list.get(size-1);
    }

    public int getMin() {
        return min.get(size-1);
    }

}
