package com.tyj.数组;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author : 唐元晋
 * @created 2022/2/6 17:43
 */
public class _188_买卖股票的最佳时机Ⅳ {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param k
     * @param prices
     * @return
     */
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            k = Math.min(k, n / 2);
            //k次交易
            int[] buy = new int[k + 1];
            int[] sell = new int[k + 1];

            //第一次交易的持有股票和不持有股票的状态
            buy[0] = -prices[0];
            sell[0] = 0;
            for (int i = 1; i <= k; ++i) {
                buy[i] = sell[i] = Integer.MIN_VALUE / 2;
            }

            for (int i = 1; i < n; ++i) {
                buy[0] = Math.max(buy[0], sell[0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    //第j次交易的持有股票状态，可能是当前未持有购入，也可能是之前持有
                    buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                    //第j次交易的未持有股票状态，可能是上一次交易正好在当前售出，也可能是之前就未持有
                    sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
                }
            }
            return Arrays.stream(sell).max().getAsInt();
        }

}
