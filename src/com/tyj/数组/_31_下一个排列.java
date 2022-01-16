package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/next-permutation/
 * @author : 唐元晋
 * @created 2022/1/16 17:46
 */
public class _31_下一个排列 {

    public static void main(String[] args) {
        int[] ma = new int[]{
                4, 6, 8, 5, 1
        };
        nextPermutation(ma);
        System.out.println(Arrays.toString(ma));
    }

    /**
     * 官方题解
     * 1.需要将一个左边的[较小数]与一个右边的[较大数]交换。以能够让当前排列变大，从而得到下一个排列。
     * 2.同时要让这个[较小数]尽量靠右，而[较大数]尽可能小。当交换完成后，[较大数]右边的需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     * 具体，对于长度为n的排列a:
     * 1.首先从后向前查找第一个顺序对(i,i+1)，满足a[i]<a[i+1]。这样(尽可能靠右的)[较小数]即为a[i]。此时[i+1,n]必然是下降序列。
     * 2.如果找到了顺序对，那么在区间[i+1,n)中从后向前查找第一个元素j满足a[i]<a[j]。这样(尽可能小的)[较大数]即为a[j]。
     * 3.交换a[i]与a[j]，此时可以证明区间[i+1,n)必为降序。可以直接使用双指针反转区间[i+1,n)使其变为升序，而无需对该区间进行排序
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        //防止下标越界
        int i = nums.length - 2;
        //从右往左查找第一个满足nums[i]<a[i+1]的nums[i]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //如果i不为负数，就说明找到了第一个顺序对，找不到说明此时整个数组是降序排列，已经是最大的排列
        if (i >= 0) {
            //从右往左找第一个满足nums[j]>nums[i]的nums[j]
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //交换nums[i]和nums[j]
            swap(nums, i, j);
        }
        //交换过来的较大数nums[i]的右边必然是降序，将nums[i]的右边一位到尾部的区间进行反转(降序排列比升序排列大，尽可能将变大的幅度降小)
        //如果输入的数组已经为最大排列(降序)，程序走到这里i为-1，会将数组反转为最小排列(升序)
        reverse(nums, i + 1);
    }

    /*
     * 辅助函数
     * 交换两个位置的元素
     * */
    public static void swap(int[] nums, int index1, int index2) {
        int tep = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tep;
    }

    /*
     * 辅助函数
     * 将数组中一个区间的排列进行反转
     * */
    public static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
