package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author : 唐元晋
 * @created 2022/2/6 15:59
 */
public class _122_买卖股票的最佳时机Ⅱ {

    /**
     * 动态规划
     * 手中没有股票的情况sell，手中有股票的情况buy
     * 手中没有股票的情况可能是前一天也没有股票，或者是今天卖出了股票
     * 手中有股票的情况可能是前一天有股票，或者是前一天未持有股票，今天又买入了股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sell=0;
        int buy=-prices[0];
        for (int i = 1; i < n; i++) {
            sell=Math.max(sell,buy+prices[i]);
            buy=Math.max(buy,sell-prices[i]);
        }
        return sell;
    }


    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
