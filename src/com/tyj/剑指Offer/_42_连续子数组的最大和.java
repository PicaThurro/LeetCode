package com.tyj.剑指Offer;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author : 唐元晋
 * @created 2021/12/28 0:59
 */
public class _42_连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (sum<nums[i]){
                sum=nums[i];
            }
            max=Math.max(max,sum);

        }
        return max;
    }

}
