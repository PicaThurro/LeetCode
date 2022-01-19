package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2022/1/18 16:22
 */
public class _48_旋转图像 {

    /**
     * 官方题解
     * n=length
     * 由于矩阵中的行列从0开始技术，因此对于矩阵中的元素matrix[row][col]，在旋转后它的新位置为matrix[col][n-row-1]
     * 由外向内交换四个角的位置
     *      temp                            == matrix[row][col]
     *      matrix[row][col]                == matrix[n-col-1][row]
     *      matrix[n-col-1][row]            == matrix[n-row-1][n-col-1]
     *      matrix[n-row-1][n-col-1]        == matrix[col][n-row-1]
     *      matrix[col][n-row-1]            == temp
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length=matrix.length;
        for (int i = 0; i < length/2; i++) {
            //当n为奇数时 length先加1再除以2 这样的边界保证了不重复、不遗漏
            for (int j = 0; j < (length+1)/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[length-j-1][i];
                matrix[length-j-1][i]=matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1]=matrix[j][length-i-1];
                matrix[j][length-i-1]=temp;
            }
        }
        System.out.println("asdasdad");
    }

}
