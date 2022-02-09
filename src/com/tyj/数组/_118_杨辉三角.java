package com.tyj.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author : 唐元晋
 * @created 2022/2/9 15:07
 */
public class _118_杨辉三角 {

    /**
     * 动态规划
     * i>=2 && j>0  也就是从第三行开始的每一行的第二列开始
     *          状态转移方程:dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> integerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i>=2&&j>0){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
                integerList.add(dp[i][j]);
            }
            list.add(integerList);
        }
        return list;
    }

}
