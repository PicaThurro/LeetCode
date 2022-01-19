package com.tyj.数学;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author : 唐元晋
 * @created 2022/1/19 19:47
 */
public class _70_爬楼梯 {

    /**
     * 规律和斐波那契数相同
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int first=1;
        int last=0;
        int temp;
        for (int i = 0; i < n; i++) {
            temp=first;
            first=first+last;
            last=temp;
        }
        return first;
    }

}
