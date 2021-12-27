package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author : 唐元晋
 * @created 2021/12/28 0:04
 */
public class _10_Ⅱ青蛙跳台阶问题 {

    public int numWays(int n) {
        if(n==0) return 1;
        if(n<=2) return n;
        final int mod =1000000007;
        int first=1;
        int second=1;
        for (int i=1;i<n;i++){
            int sum=(first+second)%mod;
            first=second;
            second=sum;
        }
        return second;
    }

}
