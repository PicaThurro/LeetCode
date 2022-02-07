package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author : 唐元晋
 * @created 2022/2/7 17:54
 */
public class _714_买卖股票的最佳时机含手续费 {

    /**
     * 动态规划 无限制次数购买
     * 逻辑与之前的题大致相同，只是在交易时需要支付手续费
     * 也就是在卖出的股票的时候再减去手续费fee即可
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length<=1){
            return 0;
        }
        int sell=0;
        int buy=-prices[0];
        for (int i = 0; i < prices.length; i++) {
            sell=Math.max(sell,buy+prices[i]-fee);
            buy=Math.max(buy,sell-prices[i]);
        }
        return sell;
    }

}
