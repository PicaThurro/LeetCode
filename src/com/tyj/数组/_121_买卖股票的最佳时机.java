package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author : 唐元晋
 * @created 2022/1/28 13:37
 */
public class _121_买卖股票的最佳时机 {


    /**
     * 动态规划
     * 手中没有股票的情况sell，手中有股票的情况buy
     * 手中没有股票的情况可能是前一天也没有股票，或者是今天卖出了股票
     * 手中有股票的情况可能是前一天有股票，或者是今天刚买入了股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sell=0;
        int buy=-prices[0];
        for (int i = 1; i < n; i++) {
            sell=Math.max(sell,buy+prices[i]);
            buy=Math.max(buy,-prices[i]);
        }
        return sell;
    }

    /**
     * 一次遍历
     * 每次循环都维持着历史最低点，然后用当前遍历到的值减去历史最低点计算出利润
     * 每次计算出的利润都与max变量比较取较大者
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len=prices.length;
        if (len<=1){
            return 0;
        }
        int max=0;
        int min=prices[0];
        for (int i = 0; i < len; i++) {
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }

}
