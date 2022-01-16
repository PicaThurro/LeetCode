package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author : 唐元晋
 * @created 2022/1/16 19:10
 */
public class _32_最长有效括号 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

    /**
     * 官方题解 动态规划
     * 定义dp[i]表示下标i字符结尾的最长有效括号的长度。将dp数组全部初始化为0
     * 有效的字符串一定以')'结尾，因此可以知道以'('结尾的子串对应的dp值必定为0，只需要求解')'在dp数组中对应位置的值
     *          从前往后遍历字符串求解dp值，每两个字符检查一次:
     *          1.s[i]=')'且s[i-1]='('，也就是字符串形如".....()"，可以推出: dp[i]=dp[i-2]+2
     *                  可以进行这样的转移，是因为结束部分的"()"是一个有效子字符串，并且将之前有效字符串的长度增加了2.
     *          2.s[i]=')'，且s[i-1]=')'，也就是字符串形如".....))"，可以推测出：
     *                  如果s[i-dp[i-1]-1]='(',那么 dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2
     *  考虑如果倒数第二个')'是一个有效字符串的一部分（记作sub），对于最后一个')'，如果它是一个更长字符串的一部分
     *  那么它一定有一个对应的'('，且它的位置在倒数第二个')'所在的有效字符串的前面(sub的前面)
     *  因此，如果子字符串sub的前面恰好是'('，那么就用上2加上sub的长度(dp[i-1])去更新dp[i]
     *  同时，也会把有效子串“（sub）”之前的有效子串的长度也加上，也就是再加上dp[i-dp[i-1]-2]
     *  最后的答案即为dp数组中的最大值
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxans=0;
        int[] dp=new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (chars[i]==')'){
                if (chars[i-1]=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else if (i-dp[i-1]>0&&chars[i-dp[i-1]-1]=='('){
                    dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            maxans=Math.max(maxans,dp[i]);
        }
        return maxans;
    }

}
