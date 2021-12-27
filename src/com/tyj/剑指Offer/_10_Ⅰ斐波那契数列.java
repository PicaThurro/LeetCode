package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author : 唐元晋
 * @created 2021/12/27 22:25
 */
public class _10_Ⅰ斐波那契数列 {

    public int fib(int n) {
        if(n<=1) return n;
        final int mod =1000000007;
        int first=0;
        int second=1;
        for (int i=1;i<n;i++){
            int sum=(first+second)%mod;
            first=second;
            second=sum;
        }
        return second;
    }

}
