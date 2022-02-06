package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author : 唐元晋
 * @created 2022/2/6 15:55
 */
public class _309_最佳买卖股票时机含冷冻期 {

    /**
     * 动态规划
     * 手中没有股票的情况sell，手中有股票的情况buy
     * 手中没有股票的情况可能是前一天也没有股票，或者是今天卖出了股票
     * 手中有股票的情况可能是前一天有股票，或者是今天刚买入了股票，由于有冷冻期所以今天不能直接买入股票,需要查看前两天不持有股票的情况
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profix_freeze=0;
        int sell=0;
        int buy=-prices[0];
        for (int i = 1; i < n; i++) {
            int temp=sell;
            sell=Math.max(sell,buy+prices[i]);
            buy=Math.max(buy,profix_freeze-prices[i]);
            profix_freeze=temp;
        }
        return sell;
    }

}
