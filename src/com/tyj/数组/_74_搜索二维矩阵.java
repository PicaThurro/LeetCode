package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author : 唐元晋
 * @created 2022/2/2 16:31
 */
public class _74_搜索二维矩阵 {

    /**
     * 官方题解 一次二分
     * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，可以在该数组上二分找到目标元素
     * 可以二分升序数组的下标，将其映射到原矩阵的行和列上
     *      int mid=(high-low)/2+low;
     *      int x=matrix[mid/filed][mid%filed];
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row= matrix.length;
        int filed=matrix[0].length;
        int low=0,high=row*filed-1;
        while (low<=high){
            int mid=(high-low)/2+low;
            int x=matrix[mid/filed][mid%filed];
            if (x<target){
                low=mid+1;
            }else if (x>target){
                high=mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

}
