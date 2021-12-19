package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author : 唐元晋
 * @created 2021/12/19 22:16
 */
public class _58_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        String result="";
        result=s.substring(n,s.length());
        result+=s.substring(0,n);
        return result;
    }

}
