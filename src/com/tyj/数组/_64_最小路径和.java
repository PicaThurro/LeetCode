package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author : 唐元晋
 * @created 2022/1/19 18:38
 */
public class _64_最小路径和 {

    /**
     * 动态规划
     * 走到f(i,j)的最小路径和，是f(i,j)加上"min(f(i-1,j),f(i,j-1))"，也就是f(i,j)的上面一个元素和左边一个元素其中较小的一个，因为只能向右和向下移动
     *          状态转移方程:
     *                  f(i,j)=f(i,j)+Math.min(f(i,j-1),f(i-1,j))
     * 但是如果i=0或j=0，f(i,j)处在网格的第一行或者是第一列，这样的话状态转移方程不成立
     * 所以先把i=0和j=0的情况单独拿出来计算(f[0][0]的情况不用考虑，想要到达f(0,0)这个位置的路径就是它自身的元素)
     *      处理网格第一行，i=0:
     *          因为此时处在网格的第一行，f(i,j)只有通过左边的路径才能到达 f(i,j)=f(i,j)f(i,j-1)即可
     *          注意上面的j-1，因为网格在第一列第一行的元素不需要处理，所以这里遍历是从第二列(j=1)开始的
     *      处理网格第一列，j=0:
     *          因为此时处在网格的第一列，f(i,j)只有通过上边的路径才能到达 f(i,j)=f(i,j)+f(i-1,j)
     *          注意上面的i-1，因为网格在第一列第一行的元素不需要处理，所以这里遍历是从第二行(i=1)开始的
     * 最后套用状态转移方程来遍历数组
     * 最小路径和的结果就是f(height-1,weight-1)
     */
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int filed=grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0]=grid[i][0]+grid[i-1][0];
        }
        for (int i = 1; i < filed; i++) {
            grid[0][i]=grid[0][i]+grid[0][i-1];
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j < filed; j++) {
                grid[i][j]=grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][filed-1];
    }


    public int minPathSum2(int[][] grid) {
        int row=grid.length;
        int filed=grid[0].length;
        int[][] dp=new int[row][filed];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < filed; i++) {
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j < filed; j++) {
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][filed-1];
    }

}
