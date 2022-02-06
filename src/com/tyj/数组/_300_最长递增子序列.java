package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author : 唐元晋
 * @created 2022/2/4 16:53
 */
public class _300_最长递增子序列 {

    /**
     * 动态规划
     * 新建一个数组dp
     * dp[i]保存的是以nums[i]为结尾的递增子序列的长度
     * 遍历nums[i]的时候从i的前一位一直往前查看每一位比nums[i]小的数谁的递增长度最长
     * 取出最长的加1保存到dp[i]
     * 然后maxLen来比较dp[i]取最长
     * 最后返回maxLen即可
     * 注意：nums遍历从1开始，因为下标0的递增子序列长度就是1
     * maxLen初始化为1，因为题目提示nums的长度最小是1个元素，遍历是从1开始的
     *      这样会无法进入循环，直接返回初始化的maxLen（1个元素的递增子序列长度就是1）
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=1;
        int maxLen=1;
        for (int i = 1; i < nums.length; i++) {
            int max=0;
            for (int j = i-1; j >=0 ; j--) {
                if (nums[j]<nums[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

}
