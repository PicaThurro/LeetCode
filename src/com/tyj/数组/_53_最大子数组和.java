package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 唐元晋
 * @created 2021/12/16 20:56
 */
public class _53_最大子数组和 {


    //动态规划
    public  int maxSubArray(int[] nums) {
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result < 0) {
                result=nums[i];
            }
            result = Math.max(result, nums[i]);
        }
        return result;
    }

}
