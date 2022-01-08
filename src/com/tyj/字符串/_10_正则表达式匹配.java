package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * @author : 唐元晋
 * @created 2022/1/8 14:59
 */
public class _10_正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","mis*is*p*."));
    }


    /**
     * 动态规划 根据官方和大佬的题解
     * 状态转移1.f[i][j]=f[i-1][j-1]
     * 状态转移2.j='*'的情况 f[i][j]=f[i][j-2] || (j-1==i && f[i-1][j]==true)
     * 状态转移3.j='.'的情况 跟状态转移1通用
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j= 1; j <= n; j++) {
                //判断当前是否字符是*
                if (p.charAt(j-1)=='*'){
                    //如果j前两位是true，就取j的前两位的值
                    if (f[i][j-2]){
                        f[i][j]=f[i][j-2];
                        //否则进入mathches先判断j的前一个字符是否与i相等，如果是的话就取i-1的值
                    }else if (mathches(s,p,i,j-1)){
                        f[i][j]=f[i-1][j];
                    }
                    //如果能通过判断，说明两个字符匹配，复制左上角的值
                }else if (mathches(s,p,i,j)){
                    f[i][j]=f[i-1][j-1];
                }
            }
        }
        //正则表达式匹配的结果就是f[][]最右下角的结果，表示了两个字符串匹配的情况
        return f[m][n];
    }

    /*
    * 辅助方法
    * 里面的任何-1操作，都是为了能够正常从字符串取出字符，不造成下标越界的情况
    * 因为f[][]的行和列是在s和p的基础上多加了1，两层for循环是在f[][]的基础上进行，而且需要匹配空字符串的情况
    * f[0][0]是两个空字符的比较,所以为true
    * */
    public static boolean mathches(String s,String p, int i,int j){
        //在第零行，直接返回false
        if (i==0){
            return false;
        }
        //表示p里的点与任何一个字符匹配，返回true
        //如果是因为*号的情况进入的此方法，下面这条逻辑可以处理".*"的情况
        if (p.charAt(j-1)=='.'){
            return true;
        }
        //匹配两个字符是否相等
        return s.charAt(i-1)==p.charAt(j-1);
    }

}
