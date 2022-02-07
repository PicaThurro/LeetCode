package com.tyj.数组;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author : 唐元晋
 * @created 2022/2/7 17:20
 */
public class _213_打家劫舍Ⅱ {

    /**
     * 动态规划
     * 头和尾相邻有三种情况：
     *         不抢头，不抢尾
     *         抢头，不抢尾
     *         不抢头，抢尾
     * 既然这样可以把数组拆分成三个依次去计算三种情况的最大值
     * 最后返回这个最大值即可
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length<=1){
            return nums.length==0?-1:nums[0];
        }
        //不抢头，不抢尾
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length - 1);
        //抢头，不抢尾
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        //不抢头，抢尾
        int[] nums3 = Arrays.copyOfRange(nums, 1, nums.length );
        return Math.max(helper(nums1),Math.max(helper(nums2),helper(nums3)));
    }

    private int helper(int[] nums) {
        if (nums.length<=1){
            return nums.length==0?-1:nums[0];
        }
        int ans=Math.max(nums[0],nums[1]);
        for (int i = 1; i < nums.length; i++) {
            if (i==1){
                nums[i]=Math.max(nums[i],nums[i-1]);
                continue;
            }
            nums[i]=Math.max(nums[i-1],nums[i-2]+nums[i]);
            ans=Math.max(ans,nums[i]);
        }
        return ans;
    }

}
