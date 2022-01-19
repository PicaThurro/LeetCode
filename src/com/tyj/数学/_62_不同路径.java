package com.tyj.数学;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/unique-paths/
 * @author : 唐元晋
 * @created 2022/1/19 18:26
 */
public class _62_不同路径 {

    /**
     * 官方题解 动态规划
     * 用f(i,j)表示从左上角走到(i,j)的路径数量，其中i和j的范围分别是[0,m)和[0,n)
     * 由于每一步只能从向下或者向右移动一步，因此要想走到(i,j)，如果向下走一步，那么会从(i-1,j)走过来
     * 如果向右走一步，那么会从(i,j-1)走过来。动态规划转移方程:
     *                  f(i,j)=f(i-1,j)+f(i,j-1)
     * 如果i=0，那f(i-1,j)并不是一个满足要求的状态，需要忽略这一项
     * 如果j=0，那(i,j-1)也不是一个满足要求的状态
     * 初始条件为f(0,0)=1，既从左上角走到左上角有一种方法
     * 最终的答案即为f(m-1,n-1)
     * 为了方便代码编写，可以将所有的f(0,j)以及(i,0)都设置为边界条件，它们的值均为1
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
