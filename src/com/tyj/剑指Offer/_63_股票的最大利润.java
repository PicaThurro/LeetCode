package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @author : 唐元晋
 * @created 2021/12/28 0:09
 */
public class _63_股票的最大利润 {


    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    //自己写的垃圾方法
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int gu = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = prices.length - 1; j > i; j--) {
                if (prices[j] - prices[i] > 0) {
                    gu = Math.max(gu, prices[j] - prices[i]);
                }
            }
        }
        return gu;
    }

}
