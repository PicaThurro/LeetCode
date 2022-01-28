package com.tyj.树;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author : 唐元晋
 * @created 2022/1/28 14:07
 */
public class _96_不同的二叉搜索树 {


    public int numTrees(int n){
        int[] G=new int[n+1];
        G[0]=1;
        G[1]=1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                G[i]+=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }

    /**
     * 卡塔兰数
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
