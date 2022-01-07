package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/find-pivot-index/
 * @author : 唐元晋
 * @created 2022/1/6 16:05
 */
public class _724_寻找数组的中心下标 {

    /**
     * 官方题解
     * 先得出数组所有元素的和total
     * 然后遍历这个数组
     * 当前下标左边的和为sum，右边的和为total-sum-nums[i](当前下标的元素，这套公式等价2 * sum + nums[i]）
     * 如果相等就返回当下下标
     * 如果循环结束都没有找到，证明没有中心所以
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }

}
