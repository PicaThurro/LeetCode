package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author : 唐元晋
 * @created 2022/1/27 16:04
 */
public class _200_岛屿数量 {

    /**
     * 根据官方的题解 深度优先搜索
     * 在遍历到一个1的时候count加一，使用辅助函数将以这个1开始相邻左右上下的1全部标记为0，表示已标记
     * 在后面再遍历到1的时候不会重复计算
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void search(char[][] grid, int row, int field) {
        if (row < 0 || row >= grid.length || field < 0 || field >= grid[0].length) {
            return;
        }
        if (grid[row][field] == '0') {
            return;
        }
        grid[row][field] = '0';
        search(grid, row + 1, field);
        search(grid, row - 1, field);
        search(grid, row, field + 1);
        search(grid, row, field - 1);
    }

}
