package com.tyj.数组;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * @author : 唐元晋
 * @created 2022/1/25 16:43
 */
public class _85_最大矩形 {

    /**
     * 此题与 84.柱状图中最大的矩形 类似
     * 将二维图转换成一维图套用 84题的单调栈逻辑即可
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length+2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]=='1'){
                    dp[i][j+1]=1;
                }
                if (i!=0&&dp[i][j+1]==1){
                    dp[i][j+1]+=dp[i-1][j+1];
                }
            }
        }

        int res=0;
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                while (!stack.isEmpty()&&dp[i][j]<dp[i][stack.peek()]){
                    int cur=stack.pop();
                    int curHeight=dp[i][cur];

                    int leftIndex=stack.peek();
                    int rightIndex=j;
                    int curWidth=rightIndex-leftIndex-1;

                    res=Math.max(res,curWidth*curHeight);
                }
                stack.push(j);
            }
            stack.clear();
        }
        return res;
    }

}
