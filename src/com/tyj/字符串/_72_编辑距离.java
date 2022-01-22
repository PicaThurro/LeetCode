package com.tyj.字符串;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/edit-distance/
 * @author : 唐元晋
 * @created 2022/1/20 15:15
 */
public class _72_编辑距离 {

    /**
     * 官方题解 动态规划
     * https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
     * f(i,j)=min( f(i-1,j-1) , f(i-1,j)+1 , f(i,j-1)+1 )
     * if(s1.charAt(i)!=s2.charAt(j))  f(i-1,j-1)也需要加上1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int word1Len=word1.length();
        int word2Len=word2.length();
        if (word1Len*word2Len==0){
            return word1Len+word2Len;
        }
        int dp[][]=new int[word1Len+1][word2Len+1];
        for (int i = 0; i < word1Len+1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < word2Len+1; i++) {
            dp[0][i]=i;
        }
        char[] word1chars = word1.toCharArray();
        char[] word2chars = word2.toCharArray();
        for (int i = 1; i < word1Len+1; i++) {
            for (int j = 1; j < word2Len+1; j++) {
                int left=dp[i][j-1]+1;
                int up=dp[i-1][j]+1;
                int leftUp=dp[i-1][j-1];
                if (word1chars[i-1]!=word2chars[j-1]){
                    leftUp+=1;
                }
                dp[i][j]=Math.min(left,Math.min(up,leftUp));
            }
        }
       return dp[word1Len][word2Len];
    }

}
