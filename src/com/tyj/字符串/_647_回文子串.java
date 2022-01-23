package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * @author : 唐元晋
 * @created 2022/1/23 15:09
 */
public class _647_回文子串 {

    /**
     * 动态规划
     * 逻辑与状态转移方程跟 5.最长回文子串 的动态规划解法相似，只是这道题的需求是返回所有回文子串的数量
     * count用于保存回文子串的数量
     * 首先先对f[][]的对角线全部赋值为true，并且每一次赋值count都加一次1，因为一个字符它自己本身就是一个回文串
     *  aba 这样长度的回文子串不需要判断去掉头和尾是否是回文子串 它一定是个回文子串 if(j-i<3){ f[i][j]=true }
     *  if(j-i<3)不满足的情况需要用到状态转移方程:  f[i][j]=f[i+1][j-1]
     *                  也就是要判断abca是不是回文子串，先去掉头和尾看看bc是不是回文子串
     *  当f[i][j]=true时，说明当前发现了一个回文子串，count++
     *  最后返回count即可
     */
    public int countSubstrings(String s) {
        int len=s.length();
        if (len==1){
            return len;
        }
        boolean[][] dp=new boolean[len][len];
        int count=0;
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
            count++;
        }

        char[] chars = s.toCharArray();
        for (int j = 1; j <len ; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i]==chars[j]){
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

}
