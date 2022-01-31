package com.tyj.位运算;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * @author : 唐元晋
 * @created 2022/1/29 16:16
 */
public class _693_交易位二进制数 {

    /**
     * 先计算出二进制数
     * 然后遍历判断相邻两个数是否相同，相同直接返回false
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int temp;
        StringBuilder sb=new StringBuilder();
        while (n>0){
            temp=n%2;
            sb.append(temp);
            n=n>>1;
        }
        for (int i = 0; i+1 < sb.length(); i++) {
            if (sb.charAt(i)==sb.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

}
