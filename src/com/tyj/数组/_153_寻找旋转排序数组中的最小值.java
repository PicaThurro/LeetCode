package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @author : 唐元晋
 * @created 2021/12/20 21:09
 */
public class _153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(right-left)/2+left;
            if (nums[mid]<nums[right]){
                right=mid;
            }else if (nums[mid]>nums[right]){
                left=mid+1;
            }
        }
        return nums[left];
    }

}
