package com.tyj.数组;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 *
 * @author : 唐元晋
 * @created 2022/2/9 14:48
 */
public class _566_重塑矩阵 {

    /**
     * 二维数组的一维表示
     *     i= x / n
     *     j= x % n
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int flied = mat[0].length;
        //判断输入数据是否有效
        if ((r * c) != (row * flied)) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < row * flied; i++) {
            ans[i/c][i%c]=mat[i/flied][i%flied];
        }
        return ans;
    }

    /**
     * 自己写的辣鸡方法
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int row = mat.length;
        int flied = mat[0].length;
        if ((r * c) != (row * flied)) {
            return mat;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                queue.offer(mat[i][j]);
            }
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = queue.poll();
            }
        }
        return ans;
    }

}
