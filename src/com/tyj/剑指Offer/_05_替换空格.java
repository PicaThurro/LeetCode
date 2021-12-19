package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author : 唐元晋
 * @created 2021/12/19 21:36
 */
public class _05_替换空格 {

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

}
