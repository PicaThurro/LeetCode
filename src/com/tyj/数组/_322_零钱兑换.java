package com.tyj.数组;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author : 唐元晋
 * @created 2022/2/7 16:08
 */
public class _322_零钱兑换 {

    /**
     * 作者：alchemist-5r
     * 链接：https://leetcode-cn.com/problems/coin-change/solution/shi-pin-tu-jie-dong-tai-gui-hua-zui-shao-zhao-ling/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int table[][] = new int[coins.length + 1][amount + 1];
        for (int col = 1; col < table[0].length; col++) {
            table[0][col] = max;
        }

        for (int row = 1; row < table.length; row++) {
            int coin = coins[row - 1];
            for (int col = 1; col < table[row].length; col++) {
                if (coin > col) {
                    table[row][col] = table[row - 1][col];
                } else {
                    table[row][col] = Math.min(table[row - 1][col], table[row][col - coin] + 1);
                }
            }
        }
        int lastRow[] = table[table.length - 1];
        int lastElement = lastRow[lastRow.length - 1];

        return lastElement == max ? -1 : lastElement;
    }

}
