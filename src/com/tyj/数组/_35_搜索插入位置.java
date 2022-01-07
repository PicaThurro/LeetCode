package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author : 唐元晋
 * @created 2022/1/6 16:35
 */
public class _35_搜索插入位置 {

    /**
     * 二分查找法
     * 如果target大于mid，left就设为mid的右一位
     * 如果target小于mid，right就设为mid的左一位
     * 循环的条件，当left严格大于right就退出
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid-1;
            } else if (target > nums[mid]) {
                left = mid+1;
            }
        }
        return left;
    }

}
