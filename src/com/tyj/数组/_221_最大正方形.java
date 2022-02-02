package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author : 唐元晋
 * @created 2022/2/1 15:42
 */
public class _221_最大正方形 {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int filed = matrix[0].length;
        int[][] dp = new int[row][filed];

        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < filed; j++) {
                if (matrix[i][j]=='1'){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                }
                maxSide=Math.max(maxSide,dp[i][j]);
            }

        }
        return maxSide*maxSide;
    }

}
