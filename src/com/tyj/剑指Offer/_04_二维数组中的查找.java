package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/20 20:38
 */
public class _04_二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

}
