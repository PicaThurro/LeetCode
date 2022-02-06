package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author : 唐元晋
 * @created 2022/2/6 17:32
 */
public class _123_买卖股票的最佳时机Ⅲ {

    /**
     * 动态规划
     * 限定两次交易，且两次交易不能同时进行
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            //可能是前一天没有股票，或者是今天刚售出了股票
            sell2 = Math.max(sell2, buy2 + prices[i]);
            //可能是前一天就持有股票，或者是在未持有另一只股票的时候今天买入了股票
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //可能是前一天没有股票，或者是今天刚售出了股票
            sell1=Math.max(sell1,buy1+prices[i]);
            //可能是前一天就持有股票，或者是今天刚购入了股票
            buy1=Math.max(buy1,-prices[i]);
        }
        return sell2;
    }

}
