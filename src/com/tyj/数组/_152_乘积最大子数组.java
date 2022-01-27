package com.tyj.数组;

/**
 * Created by IntelliJ IDEA.
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author : 唐元晋
 * @created 2022/1/27 14:46
 */
public class _152_乘积最大子数组 {

    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE,imax=1,imin=1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                int tmp=imax;
                imax=imin;
                imin=tmp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);

            max=Math.max(max,imax);
        }
        return max;
    }

}
