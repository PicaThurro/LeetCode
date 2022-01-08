package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author : 唐元晋
 * @created 2022/1/7 15:46
 */
public class _5_最长回文子串 {

    /**
     * 官方题解：动态规划
     * 如果我们已经知道 “bab” 是回文串，那么“ababa”一定是回文串，这是因为它的首尾两个字母都是“a”。
     * dp[i+1][j+1]=dp[i][j]
     * 所有单个字符本身就是一个回文串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int begin = 0;
        int maxLen = 1;

        char[] chars = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, maxLen + begin);

    }


}
