package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author : 唐元晋
 * @created 2022/2/2 16:46
 */
public class _240_搜索二维矩阵Ⅱ {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-so-9hcx/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x=0,y=n-1;
        while (x<m&&y>=0){
            if (matrix[x][y]==target){
                return true;
            }
            if (matrix[x][y]>target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }

    /**
     * 自己写的方法辣鸡方法
     * 每一行的开头元素先判断是否比target大，是的话直接返回false
     * 然后就是对这一行进行二分
     * O(m+logn)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0]>target){
                return false;
            }
            int left=0;
            int right=n-1;
            int mid;
            while (left<=right){
                mid=(right-left)/2+left;
                if (matrix[i][mid]<target){
                    left=mid+1;
                }else if (matrix[i][mid]>target){
                    right=mid-1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

}
